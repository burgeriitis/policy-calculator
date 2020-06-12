package it.proof;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class PolicyObject {
    private final String name;
    private final Map<Risk, BigDecimal> riskWithSum;
    private final List<SubObject> subObjects;

    public PolicyObject(String name, Map<Risk, BigDecimal> riskWithSum, List<SubObject> subObjects) {
        this.name = name;
        this.riskWithSum = riskWithSum;
        this.subObjects = subObjects;
    }
}
