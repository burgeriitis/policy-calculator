package it.proof.risk;

import java.math.BigDecimal;

public class RiskCoefficientFactory {

    private static final RiskCoefficients FIRE_RISK_COEFFICIENT = new RiskCoefficients(
            BigDecimal.valueOf(0.014),
            Coefficient.exclusiveCoefficient(BigDecimal.valueOf(100), BigDecimal.valueOf(0.024))
    );
    private static final RiskCoefficients THEFT_RISK_COEFFICIENT = new RiskCoefficients(
            BigDecimal.valueOf(0.11),
            Coefficient.inclusiveCoefficient(BigDecimal.valueOf(15), BigDecimal.valueOf(0.05))
    );

    public RiskCoefficients coefficientByRiskType(RiskType riskType) {
        switch (riskType) {
            case FIRE:
                return FIRE_RISK_COEFFICIENT;
            case THEFT:
                return THEFT_RISK_COEFFICIENT;
            default:
                throw new RuntimeException("Unknown risk " + riskType);
        }
    }
}
