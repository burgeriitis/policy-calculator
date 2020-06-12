package it.proof;

import java.math.BigDecimal;
import java.util.Map;

public class SubObject {
    private final String name;
    private final Map<Risk, BigDecimal> riskWithSum;

    public SubObject(String name, Map<Risk, BigDecimal> riskWithSum) {
        this.name = name;
        this.riskWithSum = riskWithSum;
    }
}
