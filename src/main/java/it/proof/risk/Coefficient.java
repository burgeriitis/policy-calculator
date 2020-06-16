package it.proof.risk;

import java.math.BigDecimal;

class Coefficient {
    private final BigDecimal lowerBound;
    private final BigDecimal coefficient;
    private final Boolean isInclusive;

    static Coefficient inclusiveCoefficient(BigDecimal lowerBound, BigDecimal coefficient) {
        return new Coefficient(lowerBound, coefficient, true);
    }

    static Coefficient exclusiveCoefficient(BigDecimal lowerBound, BigDecimal coefficient) {
        return new Coefficient(lowerBound, coefficient, false);
    }

    Coefficient(BigDecimal lowerBound, BigDecimal coefficient, Boolean inclusive) {
        this.lowerBound = lowerBound;
        this.coefficient = coefficient;
        this.isInclusive = inclusive;
    }

    BigDecimal lowerBound() {
        return lowerBound;
    }

    BigDecimal coefficient() {
        return coefficient;
    }

    Boolean isInclusive() {
        return isInclusive;
    }
}
