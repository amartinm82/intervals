package usantatecla;

public class ClosedMaxTest extends MaxTest {

    @Override
    protected Limit createLimit() {
        return new ClosedMax(this.point.getEquals());
    }

    @Override
    protected boolean isWithinWithEqualsValue() {
        return true;
    }

}
