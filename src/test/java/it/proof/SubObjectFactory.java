package it.proof;

import it.proof.policy.SubObject;
import it.proof.risk.RiskType;

import java.math.BigDecimal;

public class SubObjectFactory {

    public static final BigDecimal KNIFE_INSURANCE_SUM = BigDecimal.valueOf(8.00);
    public static final BigDecimal PC_INSURANCE_SUM = BigDecimal.valueOf(100.00);
    public static final BigDecimal STOVE_INSURANCE_SUM = BigDecimal.TEN;

    public static SubObject theftInsuredKnife() {
        return new SubObject("Knife", RiskType.THEFT, KNIFE_INSURANCE_SUM);
    }

    public static SubObject fireInsuredPC() {
        return new SubObject("PC", RiskType.FIRE, PC_INSURANCE_SUM);
    }

    public static SubObject fireInsuredStove() {
        return new SubObject("Stove", RiskType.FIRE, STOVE_INSURANCE_SUM);
    }
}
