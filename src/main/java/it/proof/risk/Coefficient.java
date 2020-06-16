package it.proof.risk;

import java.math.BigDecimal;

class Coefficient {
    private final BigDecimal lowerBound;
    private final BigDecimal coefficientValue;
    private final Boolean isInclusive;

    static Coefficient inclusiveCoefficient(BigDecimal lowerBound, BigDecimal coefficient) {
        return new Coefficient(lowerBound, coefficient, true);
    }

    static Coefficient exclusiveCoefficient(BigDecimal lowerBound, BigDecimal coefficient) {
        return new Coefficient(lowerBound, coefficient, false);
    }

    Coefficient(BigDecimal lowerBound, BigDecimal coefficientValue, Boolean isInclusive) {
        this.lowerBound = lowerBound;
        this.coefficientValue = coefficientValue;
        this.isInclusive = isInclusive;
    }

    BigDecimal lowerBound() {
        return lowerBound;
    }

    BigDecimal coefficient() {
        return coefficientValue;
    }

    Boolean isInclusive() {
        return isInclusive;
    }
}
