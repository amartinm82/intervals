package usantatecla;

public class ClosedMinTest extends MinTest {

    @Override
    protected End createEnd() {
        return new ClosedMin(this.point.getEquals());
    }

    @Override
    protected boolean isWithinWithEqualsValue() {
        return true;
    }

}
