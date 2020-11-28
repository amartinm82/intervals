package usantatecla;

public class MaxTest extends EndTest {

    @Override
    protected End createEnd() {
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
