package amartinm;

public class ClosedMinTest extends MinTest {

    @Override
    protected Limit createLimit() {
        return new ClosedMin(this.point.getEquals());
    }

    @Override
    protected boolean isWithinWithEqualsValue() {
        return true;
    }

}
