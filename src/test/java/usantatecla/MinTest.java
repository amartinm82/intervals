package usantatecla;

public class MinTest extends EndTest {

    protected End createEnd() {
        return new Min(this.point.getEquals());
    }

    @Override
    protected boolean isWithinWithLessValue() {
        return false;
    }

    @Override
    protected boolean isWithinWithEqualsValue() {
        return false;
    }

    @Override
    protected boolean isWithinWithGreaterValue() {
        return true;
    }

}

