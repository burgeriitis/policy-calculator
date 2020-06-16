package it.proof.policy;

import it.proof.risk.RiskType;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class PolicyObject {
    private final String name;
    private final List<SubObject> subObjects;

    public PolicyObject(String name, List<SubObject> subObjects) {
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
