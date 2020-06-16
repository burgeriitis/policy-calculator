package it.proof.risk;

import it.proof.ValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RiskCoefficientFactoryTest {

    private final RiskCoefficientFactory riskCoefficientFactory = new RiskCoefficientFactory();

    @Test
    void coefficientByRiskType_throwsException() {
        assertThrows(ValidationException.class, () -> riskCoefficientFactory.coefficientByRiskType(null));
    }
}