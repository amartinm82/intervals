package amartinm;

public class MaxTest extends LimitTest {

    @Override
    protected Limit createLimit() {
        return new Max(this.point.getEquals());
    }

    @Override
    protected boolean isWithinWithLessValue() {
        return true;
    }

    @Override
    protected boolean isWithinWithEqualsValue() {
        return false;
    }

    @Override
    protected boolean isWithinWithGreaterValue() {
        return false;
    }

}
