package it.proof.policy;

import it.proof.ValidationException;
import it.proof.risk.RiskType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import static it.proof.SubObjectFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PolicyTest {

    @Test
    void totalInsuredSumByRisk_fire() {
        BigDecimal actualSum = policyWithObjects().totalInsuredSumByRisk(RiskType.FIRE);
        assertEquals(STOVE_INSURANCE_SUM.add(PC_INSURANCE_SUM), actualSum);
    }

    @Test
    void totalInsuredSumByRisk_theft() {
        BigDecimal actualSum = policyWithObjects().totalInsuredSumByRisk(RiskType.THEFT);
        assertEquals(KNIFE_INSURANCE_SUM, actualSum);
    }

    @Test
    void totalInsuredSumByRisk_withoutRisk() {
        BigDecimal actualSum = policyWithObjects().totalInsuredSumByRisk(null);
        assertEquals(BigDecimal.ZERO, actualSum);
    }

    @Test
    void totalInsuredSumByRisk_withoutPolicyObject() {
        BigDecimal actualSum = new Policy("AF12", PolicyStatus.REGISTERED, Collections.emptyList())
                .totalInsuredSumByRisk(RiskType.FIRE);
        assertEquals(BigDecimal.ZERO, actualSum);
    }

    private static Policy policyWithObjects() {
        return new Policy("AF12", PolicyStatus.REGISTERED, Arrays.asList(flat(), house()));
    }

    private static PolicyObject flat() {
        return new PolicyObject("Flat", Arrays.asList(theftInsuredKnife(), fireInsuredStove()));
    }

    private static PolicyObject house() {
        return new PolicyObject("House", Collections.singletonList(fireInsuredPC()));
    }
}