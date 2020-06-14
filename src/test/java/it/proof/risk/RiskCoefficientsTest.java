package it.proof.risk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RiskCoefficientsTest {

    public static final BigDecimal FIRST_STEP_AMOUNT = BigDecimal.TEN;

    @ParameterizedTest
    @MethodSource("sumAndExpected")
    void calculateAmount_firstStepIncluded(BigDecimal sum, BigDecimal expected) {
        BigDecimal actualAmount = riskCoefficients().calculateAmount(sum);
        assertEquals(expected, actualAmount);
    }

    private static Stream<Arguments> sumAndExpected() {
        return Stream.of(
                Arguments.of(BigDecimal.ZERO, setScale(BigDecimal.ZERO)),
                Arguments.of(BigDecimal.valueOf(5.56), BigDecimal.valueOf(0.1112)),
                Arguments.of(FIRST_STEP_AMOUNT, setScale(BigDecimal.valueOf(0.4))),
                Arguments.of(BigDecimal.valueOf(10.01), BigDecimal.valueOf(0.4004))
        );
    }

    @ParameterizedTest
    @MethodSource("sumAndExpectedOther")
    void calculateAmount_firstStepNotIncluded(BigDecimal sum, BigDecimal expected) {
        BigDecimal actualAmount = riskCoefficients().calculateAmount(sum);
        assertEquals(expected, actualAmount);
    }

    private static Stream<Arguments> sumAndExpectedOther() {
        return Stream.of(
                Arguments.of(BigDecimal.ZERO, setScale(BigDecimal.ZERO)),
                Arguments.of(BigDecimal.valueOf(5.56), BigDecimal.valueOf(0.1112)),
                Arguments.of(FIRST_STEP_AMOUNT, setScale(BigDecimal.valueOf(0.2))),
                Arguments.of(BigDecimal.valueOf(10.01), BigDecimal.valueOf(0.4004))
        );
    }

    private RiskCoefficients riskCoefficients() {
        return new RiskCoefficients(BigDecimal.valueOf(0.02), BigDecimal.TEN, BigDecimal.valueOf(0.04));
    }

    private static BigDecimal setScale(BigDecimal value) {
        return value.setScale(2, RoundingMode.HALF_UP);
    }
}