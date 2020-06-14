package it.proof.risk;

import java.math.BigDecimal;

public class RiskCoefficients {

    private final BigDecimal defaultCoefficient;
    private final BigDecimal firstStepAmount;
    private final BigDecimal firstStepCoefficient;

    public RiskCoefficients(BigDecimal defaultCoefficient, BigDecimal firstStepAmount, BigDecimal firstStepCoefficient) {
        this.defaultCoefficient = defaultCoefficient;
        this.firstStepAmount = firstStepAmount;
        this.firstStepCoefficient = firstStepCoefficient;
    }

    private BigDecimal defaultCoefficient() {
        return defaultCoefficient;
    }

    private BigDecimal firstStepAmount() {
        return firstStepAmount;
    }

    private BigDecimal firstStepCoefficient() {
        return firstStepCoefficient;
    }

    public BigDecimal calculateAmount(BigDecimal sum) {
        if (firstStepAmount().compareTo(sum) <= 0) {//TODO fix calculation to pass all tests
            return sum.multiply(firstStepCoefficient());
        } else {
            return sum.multiply(defaultCoefficient());
        }
    }
}
