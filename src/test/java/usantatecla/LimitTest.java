package usantatecla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class LimitTest {

    protected Limit limit;
    protected Point point;

    @BeforeEach
    public void before() {
        this.point = new Point(4.4);
        this.limit = this.createLimit();
    }

    protected abstract Limit createLimit();

    protected abstract boolean isWithinWithLessValue();

    protected abstract boolean isWithinWithEqualsValue();

    protected abstract boolean isWithinWithGreaterValue();

    @Test
    public void givenLimitWhenIsWithinWithLessValue() {
        assertEquals(this.isWithinWithLessValue(), this.limit.isWithin(this.point.getLess()));
    }

    @Test
    public void givenLimitWhenIsWithinWithEqualsValue() {
        assertEquals(this.isWithinWithEqualsValue(), this.limit.isWithin(this.point.getEquals()));
    }

    @Test
    public void givenLimitWhenIsWithinWithGreaterValue() {
        assertEquals(this.isWithinWithGreaterValue(), this.limit.isWithin(this.point.getGreater()));
    }

}
