package it.proof.risk;

import java.math.BigDecimal;

public class RiskCoefficients {

    private final Coefficient defaultCoefficient;

    private final Coefficient firstStep;

    public RiskCoefficients(BigDecimal defaultCoefficientValue, Coefficient firstStep) {
        this.defaultCoefficient = Coefficient.inclusiveCoefficient(BigDecimal.ZERO, defaultCoefficientValue);
        this.firstStep = firstStep;
    }

    public BigDecimal calculateAmount(BigDecimal sum) {
        final BigDecimal actualCoefficient = shouldUseFirstStep(sum) ? firstStep.coefficient() : defaultCoefficient.coefficient();
        return sum.multiply(actualCoefficient);
    }

    private boolean shouldUseFirstStep(BigDecimal sum) {
        int firstStepCompareWithSum = firstStep.lowerBound().compareTo(sum);
        return (firstStep.isInclusive() && firstStepCompareWithSum <= 0)
                || (!firstStep.isInclusive() && firstStepCompareWithSum < 0);
    }
}
