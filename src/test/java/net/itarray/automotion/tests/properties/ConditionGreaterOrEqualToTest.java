package net.itarray.automotion.tests.properties;

import net.itarray.automotion.internal.geometry.Direction;
import net.itarray.automotion.internal.geometry.Scalar;
import net.itarray.automotion.internal.properties.Context;
import net.itarray.automotion.validation.properties.Condition;
import org.junit.Before;
import org.junit.Test;

import static net.itarray.automotion.internal.geometry.Scalar.scalar;
import static org.assertj.core.api.Assertions.assertThat;

public class ConditionGreaterOrEqualToTest extends ScalarConditionTest {

    private Scalar limit;

    @Before
    public void createProperty() {
        limit = scalar(7);
        condition = Condition.greaterOrEqualTo(limit);
    }

    @Test
    public void isSatisfiedOnValuesSmallerThanTheLimit() {
        assertThat(satisfiedOn(limit.minus(1))).isFalse();
        assertThat(satisfiedOnWithTolerance(limit.minus(2))).isFalse();
    }

    @Test
    public void isSatisfiedOnValuesEqualToTheLimit() {
        assertThat(satisfiedOn(limit)).isTrue();
        assertThat(satisfiedOnWithTolerance(limit)).isTrue();
        assertThat(satisfiedOnWithTolerance(limit.minus(1))).isTrue();
    }

    @Test
    public void isSatisfiedOnValuesGreaterThanTheLimit() {
        assertThat(satisfiedOn(limit.plus(1))).isTrue();
        assertThat(satisfiedOnWithTolerance(limit.plus(1))).isTrue();
    }

    @Test
    public void isEqualToLessOrEqualConditionsWithEqualLimit() {
        assertThat(condition).isEqualTo(Condition.greaterOrEqualTo(limit));
        assertThat(condition.hashCode()).isEqualTo(Condition.greaterOrEqualTo(limit).hashCode());
    }

    @Test
    public void isNotEqualToLessOrEqualConditionsWithDifferentLimit() {
        assertThat(condition).isNotEqualTo(Condition.greaterOrEqualTo(limit.plus(1)));
    }

    @Test
    public void isNotEqualToObjects() {
        assertThat(condition).isNotEqualTo(new Object());
    }

    @Test
    public void isNotEqualToNull() {
        assertThat(condition).isNotEqualTo(null);
    }
}
