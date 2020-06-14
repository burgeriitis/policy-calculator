package it.proof;

import it.proof.policy.Policy;
import it.proof.risk.RiskCoefficientFactory;
import it.proof.risk.RiskType;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PremiumCalculator {
    private final RiskCoefficientFactory riskCoefficientFactory;

    public PremiumCalculator(RiskCoefficientFactory riskCoefficientFactory) {
        this.riskCoefficientFactory = riskCoefficientFactory;
    }

    public BigDecimal calculate(Policy policy) {
        BigDecimal premiumSum = BigDecimal.ZERO;
        for (RiskType riskType : RiskType.values()) {
            premiumSum = premiumSum.add(sumForType(policy, riskType));
        }
        return premiumSum.setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal sumForType(Policy policy, RiskType type) {
        BigDecimal totalSumForType = policy.totalInsuredSumByRisk(type);
        return riskCoefficientFactory.coefficientByRiskType(type)
                .calculateAmount(totalSumForType);
    }
}
