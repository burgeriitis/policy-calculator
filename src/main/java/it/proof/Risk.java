package it.proof;

import java.math.BigDecimal;

public enum Risk {
    FIRE, THEFT;

    private static final RiskCoefficients fireRiskCoefficient = new RiskCoefficients(0.11, BigDecimal.valueOf(100), 0.05);
    private static final RiskCoefficients theftRiskCoefficient = new RiskCoefficients(0.14, BigDecimal.valueOf(15), 0.024);

    public RiskCoefficients getCoefficientByRisk(Risk risk) {
        switch (risk) {
            case FIRE:
                return fireRiskCoefficient;
            case THEFT:
                return theftRiskCoefficient;
            default:
                throw new RuntimeException("Unknown risk " + risk);
        }
    }
}
