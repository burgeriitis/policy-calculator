package it.proof.policy;

import it.proof.risk.RiskType;

import java.math.BigDecimal;
import java.util.List;

public class Policy {
    private final String number;
    private final PolicyStatus status;
    private final List<PolicyObject> policyObjects;

    public Policy(String number, PolicyStatus status, List<PolicyObject> policyObjects) {
        this.number = number;
        this.status = status;
        this.policyObjects = policyObjects;
    }

    public String number() {
        return number;
    }

    public PolicyStatus status() {
        return status;
    }

    public List<PolicyObject> policyObjects() {
        return policyObjects;
    }

    public BigDecimal totalInsuredSumByRisk(final RiskType riskType) {
        return policyObjects.stream()
                .map(obj -> obj.subObjectSumByType(riskType))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
