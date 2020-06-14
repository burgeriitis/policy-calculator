package it.proof.risk;

import java.math.BigDecimal;

public class RiskCoefficients {
    private final Double defaultCoefficient;
    private final BigDecimal firstStepAmount;
    private final Double firstStepCoefficient;

    public RiskCoefficients(Double defaultCoefficient, BigDecimal firstStepAmount, Double firstStepCoefficient) {
        this.defaultCoefficient = defaultCoefficient;
        this.firstStepAmount = firstStepAmount;
        this.firstStepCoefficient = firstStepCoefficient;
    }

    public Double defaultCoefficient() {
        return defaultCoefficient;
    }

    public BigDecimal firstStepAmount() {
        return firstStepAmount;
    }

    public Double firstStepCoefficient() {
        return firstStepCoefficient;
    }
}
