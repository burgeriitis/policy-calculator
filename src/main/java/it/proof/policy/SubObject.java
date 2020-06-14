package it.proof.policy;

import it.proof.risk.RiskType;

import java.math.BigDecimal;
import java.util.Objects;

public class SubObject {
    private final String name;
    private final RiskType riskType;
    private final BigDecimal sumInsured;

    public SubObject(String name, RiskType riskType, BigDecimal sumInsured) {
        this.name = name;
        this.riskType = riskType;
        this.sumInsured = sumInsured;
    }

    public String name() {
        return name;
    }

    public RiskType riskType() {
        return riskType;
    }

    public BigDecimal sumInsured() {
        return sumInsured;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubObject)) return false;
        SubObject subObject = (SubObject) o;
        return name.equals(subObject.name) &&
                riskType == subObject.riskType &&
                sumInsured.equals(subObject.sumInsured);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, riskType, sumInsured);
    }
}
