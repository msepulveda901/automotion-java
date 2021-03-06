package net.itarray.automotion.tests.geometry;

import net.itarray.automotion.internal.geometry.Interval;
import org.junit.Test;

import static net.itarray.automotion.internal.geometry.Interval.interval;
import static org.assertj.core.api.Assertions.assertThat;

public class ContainedIntervalsTest extends TwoIntervalsTest{

    public Interval left() {
        return interval(12, 15);
    }

    public Interval right() {
        return interval(20, 20);
    }

    @Test
    public void haveEmptyIntersection() {
        assertThat(right().intersect(left()).isEmpty()).isTrue();
    }

    @Test
    public void haveSpanEqualToTheNonEmptyInterval() {
        Interval span = left();
        assertThat(right().span(left())).isEqualTo(span);
        assertThat(left().span(right())).isEqualTo(span);
    }
}
