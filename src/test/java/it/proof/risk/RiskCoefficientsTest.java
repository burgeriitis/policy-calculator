package it.proof.risk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RiskCoefficientsTest {

    public static final BigDecimal DEFAULT_COEFFICIENT_VALUE = BigDecimal.valueOf(0.02);
    public static final BigDecimal FIRST_STEP_LOWER_BOUND = BigDecimal.TEN;
    public static final BigDecimal FIRST_STEP_COEFFICIENT_VALUE = BigDecimal.valueOf(0.04);

    @ParameterizedTest
    @MethodSource("sumAndExpectedFirstStepInclusive")
    void calculateAmount_firstStepInclusive(BigDecimal sum, BigDecimal expected) {
        BigDecimal actualAmount = riskCoefficients(true).calculateAmount(sum);
        assertEquals(expected, actualAmount);
    }

    private static Stream<Arguments> sumAndExpectedFirstStepInclusive() {
        return Stream.of(
                Arguments.of(BigDecimal.ZERO, setScale(BigDecimal.ZERO)),
                Arguments.of(BigDecimal.valueOf(5.56), BigDecimal.valueOf(0.1112)),
                Arguments.of(FIRST_STEP_LOWER_BOUND, setScale(BigDecimal.valueOf(0.4))),
                Arguments.of(BigDecimal.valueOf(10.01), BigDecimal.valueOf(0.4004))
        );
    }

    @ParameterizedTest
    @MethodSource("sumAndExpectedFirstStepExclusive")
    void calculateAmount_firstStepExclusive(BigDecimal sum, BigDecimal expected) {
        BigDecimal actualAmount = riskCoefficients(false).calculateAmount(sum);
        assertEquals(expected, actualAmount);
    }

    private static Stream<Arguments> sumAndExpectedFirstStepExclusive() {
        return Stream.of(
                Arguments.of(BigDecimal.ZERO, setScale(BigDecimal.ZERO)),
                Arguments.of(BigDecimal.valueOf(5.56), BigDecimal.valueOf(0.1112)),
                Arguments.of(FIRST_STEP_LOWER_BOUND, setScale(BigDecimal.valueOf(0.2))),
                Arguments.of(BigDecimal.valueOf(10.01), BigDecimal.valueOf(0.4004))
        );
    }

    private RiskCoefficients riskCoefficients(Boolean isInclusive) {
        return new RiskCoefficients(
                DEFAULT_COEFFICIENT_VALUE,
                new Coefficient(FIRST_STEP_LOWER_BOUND, FIRST_STEP_COEFFICIENT_VALUE, isInclusive)
        );
    }

    private static BigDecimal setScale(BigDecimal value) {
        return value.setScale(2, RoundingMode.HALF_UP);
    }
}