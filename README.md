##Description

- Used technologies: Java 11, JUnit5 and Gradle. Code is written in self explanatory manner (as much as author could) using provided requirements.
- Gradle wrapper is added to ensure build consistency between machines. 
- To run tests use `gradle clean test`

- As entrypoint is used PremiumCalculator.calculate method. This implementation can be run from unit test suite. Or if needed - used in further system evolution.
- If new risk type needs to be added code should be changed in 2 places:
    * new RiskType enum must be added;
    * values for new risk type Coefficients must be added in RiskCoefficientFactory.
