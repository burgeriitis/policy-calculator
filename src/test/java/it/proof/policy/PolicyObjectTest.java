package it.proof.policy;

import it.proof.risk.RiskType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static it.proof.SubObjectFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PolicyObjectTest {

    @ParameterizedTest
    @MethodSource("riskTypes")
    void subObjectsByType(RiskType testedRiskType, BigDecimal expectedSum) {
        PolicyObject policyObject = new PolicyObject("Flat 1", insuredSubObjects());
        assertEquals(expectedSum, policyObject.subObjectSumByType(testedRiskType));
    }

    private static Stream<Arguments> riskTypes() {
        return Stream.of(
                Arguments.of(RiskType.THEFT, KNIFE_INSURANCE_SUM),
                Arguments.of(RiskType.FIRE, STOVE_INSURANCE_SUM.add(PC_INSURANCE_SUM)),
                Arguments.of(null, BigDecimal.ZERO)
        );
    }

    private List<SubObject> insuredSubObjects() {
        List<SubObject> subObjects = new ArrayList<>();
        subObjects.addAll(fireInsuredObjects());
        subObjects.addAll(theftInsuredObjects());
        return subObjects;
    }

    private static List<SubObject> fireInsuredObjects() {
        return Arrays.asList(
                fireInsuredPC(),
                fireInsuredStove()
        );
    }

    private static List<SubObject> theftInsuredObjects() {
        return Collections.singletonList(theftInsuredKnife());
    }
}