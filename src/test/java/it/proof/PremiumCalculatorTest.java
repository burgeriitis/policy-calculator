package it.proof;

import it.proof.policy.Policy;
import it.proof.policy.PolicyObject;
import it.proof.risk.RiskCoefficientFactory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import static it.proof.SubObjectFactory.fireInsuredPC;
import static it.proof.SubObjectFactory.theftInsuredKnife;
import static it.proof.policy.PolicyStatus.REGISTERED;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PremiumCalculatorTest {

    @Test
    void calculate() {
        Policy policy = new Policy("AF1", REGISTERED, Collections.singletonList(flat()));
        assertEquals(BigDecimal.valueOf(2.28), new PremiumCalculator(new RiskCoefficientFactory()).calculate(policy));
    }

    private static PolicyObject flat() {
        return new PolicyObject("Flat", Arrays.asList(fireInsuredPC(), theftInsuredKnife()));
    }
}
