package it.proof;

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
}
