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
        int comparison = firstStep.lowerBound().compareTo(sum);
        final BigDecimal actualCoefficient;
        if (firstStep.isInclusive() && comparison <= 0 || !firstStep.isInclusive() && comparison < 0) {
            actualCoefficient = firstStep.coefficient();
        } else {
            actualCoefficient = defaultCoefficient.coefficient();
        }
        return sum.multiply(actualCoefficient);
    }
}
