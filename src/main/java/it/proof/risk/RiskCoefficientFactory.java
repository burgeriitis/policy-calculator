package it.proof.risk;

import java.math.BigDecimal;

public class RiskCoefficientFactory {

    private static final RiskCoefficients fireRiskCoefficient = new RiskCoefficients(0.11, BigDecimal.valueOf(100), 0.05);
    private static final RiskCoefficients theftRiskCoefficient = new RiskCoefficients(0.14, BigDecimal.valueOf(15), 0.024);

    public RiskCoefficients coefficientByRiskType(RiskType riskType) {
        switch (riskType) {
            case FIRE:
                return fireRiskCoefficient;
            case THEFT:
                return theftRiskCoefficient;
            default:
                throw new RuntimeException("Unknown risk " + riskType);
        }
    }
}
