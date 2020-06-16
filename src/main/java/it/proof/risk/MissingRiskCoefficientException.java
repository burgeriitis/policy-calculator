package it.proof.risk;

public class MissingRiskCoefficientException extends RuntimeException {
    public MissingRiskCoefficientException(String message) {
        super(message);
    }
}
