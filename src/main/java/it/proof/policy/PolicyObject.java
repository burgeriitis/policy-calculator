package it.proof.policy;

import it.proof.ValidationException;
import it.proof.risk.RiskType;

import java.math.BigDecimal;
import java.util.List;

public class PolicyObject {
    private static final int MINIMAL_SUB_OBJECT_COUNT = 1;

    private final String name;
    private final List<SubObject> subObjects;

    public PolicyObject(String name, List<SubObject> subObjects) {
        if (subObjects.size() < MINIMAL_SUB_OBJECT_COUNT) {
            throw new ValidationException("Should provide at least " + MINIMAL_SUB_OBJECT_COUNT + " 1 sub object!");
        }
        this.name = name;
        this.subObjects = subObjects;
    }

    public String name() {
        return name;
    }

    public List<SubObject> subObjects() {
        return subObjects;
    }

    public BigDecimal subObjectSumByType(RiskType type) {
        return subObjects.stream()
                .filter(subObject -> subObject.riskType().equals(type))
                .map(SubObject::sumInsured)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
