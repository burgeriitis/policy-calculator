package it.proof;

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

    public Double getDefaultCoefficient() {
        return defaultCoefficient;
    }

    public BigDecimal getFirstStepAmount() {
        return firstStepAmount;
    }

    public Double getFirstStepCoefficient() {
        return firstStepCoefficient;
    }
}
