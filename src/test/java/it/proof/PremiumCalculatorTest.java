package it.proof;

import it.proof.policy.Policy;
import it.proof.policy.PolicyObject;
import it.proof.risk.RiskCoefficientDefinitions;
import it.proof.risk.RiskCoefficientFactory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;

import static it.proof.SubObjectFactory.fireInsuredPC;
import static it.proof.SubObjectFactory.theftInsuredKnife;
import static it.proof.policy.PolicyStatus.APPROVED;
import static it.proof.policy.PolicyStatus.REGISTERED;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PremiumCalculatorTest {

    private final RiskCoefficientFactory riskCoefficientFactory = new RiskCoefficientDefinitions();
    private final PremiumCalculator premiumCalculator = new PremiumCalculator(riskCoefficientFactory);

    @Test
    void calculate_firstExample() {
        Policy policy = new Policy("AF1", REGISTERED, Collections.singletonList(flat()));
        assertEquals(BigDecimal.valueOf(2.28), premiumCalculator.calculate(policy));
    }

    @Test
    void calculate_secondExample() {
        Policy policy = new Policy("AF1", APPROVED, Collections.singletonList(expensiveHouse()));
        assertEquals(BigDecimal.valueOf(17.13), premiumCalculator.calculate(policy));
    }

    @Test
    void calculate_EmptyPolicy() {
        Policy policy = new Policy("AF1", REGISTERED, Collections.emptyList());
        assertEquals(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP), premiumCalculator.calculate(policy));
    }

    private static PolicyObject flat() {
        return new PolicyObject("Flat", Arrays.asList(fireInsuredPC(), theftInsuredKnife()));
    }

    private static PolicyObject expensiveHouse() {
        return new PolicyObject("House", Arrays.asList(
                fireInsuredPC(BigDecimal.valueOf(500.00)),
                theftInsuredKnife(BigDecimal.valueOf(102.51))
        ));
    }
}
