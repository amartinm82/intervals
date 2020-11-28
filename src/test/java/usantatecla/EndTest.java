package usantatecla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class EndTest {

    protected End end;
    protected Point point;

    @BeforeEach
    public void before() {
        this.point = new Point(4.4);
        this.end = this.createEnd();
    }

    protected abstract End createEnd();

    protected abstract boolean isWithinWithLessValue();

    protected abstract boolean isWithinWithEqualsValue();

    protected abstract boolean isWithinWithGreaterValue();

    @Test
    public void givenEndWhenIsWithinWithLessValue() {
        assertEquals(this.isWithinWithLessValue(), this.end.isWithin(this.point.getLess()));
    }

    @Test
    public void givenEndWhenIsWithinWithEqualsValue() {
        assertEquals(this.isWithinWithEqualsValue(), this.end.isWithin(this.point.getEquals()));
    }

    @Test
    public void givenEndWhenIsWithinWithGreaterValue() {
        assertEquals(this.isWithinWithGreaterValue(), this.end.isWithin(this.point.getGreater()));
    }

}
