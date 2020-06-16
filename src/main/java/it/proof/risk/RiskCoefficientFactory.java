package it.proof.risk;

/**
 * This interface should be used to easier vary between ways of providing RiskCoefficients for risk types
 * F.e.- definitions in code, from property files etc.
 */
public interface RiskCoefficientFactory {

    RiskCoefficients getCoefficients(RiskType riskType);
}
