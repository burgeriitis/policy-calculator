package it.proof.risk;

import it.proof.ValidationException;

import java.math.BigDecimal;

public class RiskCoefficientDefinitions implements RiskCoefficientFactory {

    public static final BigDecimal FIRE_DEFAULT_COEFFICIENT_VALUE = BigDecimal.valueOf(0.014);
    public static final BigDecimal FIRE_FIRST_STEP_LOWER_BOUND = BigDecimal.valueOf(100);
    public static final BigDecimal FIRE_FIRST_STEP_COEFFICIENT = BigDecimal.valueOf(0.024);

    public static final BigDecimal THEFT_DEFAULT_COEFFICIENT_VALUE = BigDecimal.valueOf(0.11);
    public static final BigDecimal THEFT_FIRST_STEP_LOWER_BOUND = BigDecimal.valueOf(15);
    public static final BigDecimal THEFT_FIRST_STEP_COEFFICIENT = BigDecimal.valueOf(0.05);

    private static final RiskCoefficients FIRE_RISK_COEFFICIENT = new RiskCoefficients(
            FIRE_DEFAULT_COEFFICIENT_VALUE,
            Coefficient.exclusiveCoefficient(FIRE_FIRST_STEP_LOWER_BOUND, FIRE_FIRST_STEP_COEFFICIENT)
    );
    private static final RiskCoefficients THEFT_RISK_COEFFICIENT = new RiskCoefficients(
            THEFT_DEFAULT_COEFFICIENT_VALUE,
            Coefficient.inclusiveCoefficient(THEFT_FIRST_STEP_LOWER_BOUND, THEFT_FIRST_STEP_COEFFICIENT)
    );

    @Override
    public RiskCoefficients getCoefficients(RiskType riskType) {
        if (riskType == null) {
            throw new ValidationException("Risk provided as null!");
        }
        switch (riskType) {
            case FIRE:
                return FIRE_RISK_COEFFICIENT;
            case THEFT:
                return THEFT_RISK_COEFFICIENT;
            default:
                throw new MissingRiskCoefficientException("Unknown risk " + riskType);
        }
    }
}
