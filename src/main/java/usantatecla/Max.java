package usantatecla;

public class Max extends Limit {

    public Max(double value) {
        super(value);
    }

    @Override
    public boolean isWithin(double value) {
        return this.value > value;
    }

    @Override
    public String toString() {
        return this.value + ")";
    }

}
