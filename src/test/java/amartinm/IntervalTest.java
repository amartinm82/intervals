package amartinm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntervalTest {

    private Point left;
    private Point right;

    @BeforeEach
    public void before() {
        this.left = new Point(-2.2);
        this.right = new Point(4.4);
    }

    static IntervalBuilder intervalBuilder() {
        return new IntervalBuilder();
    }

    @Test
    public void givenIntervalOpenOpenWhenIncludeWithIncludedValueThenTrue() {
        Interval interval = intervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
        assertFalse(interval.include(left.getLess()));
        assertFalse(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));
        assertTrue(interval.include(right.getLess()));
        assertFalse(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    public void givenIntervalClosedOpenWhenIncludeWithIncludedValueThenTrue() {
        Interval interval = intervalBuilder().closed(left.getEquals()).open(right.getEquals()).build();
        assertFalse(interval.include(left.getLess()));
        assertTrue(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertFalse(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    public void givenIntervalOpenClosedWhenIncludeWithIncludedValueThenTrue() {
        Interval interval = intervalBuilder().open(left.getEquals()).closed(right.getEquals()).build();
        assertFalse(interval.include(left.getLess()));
        assertFalse(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertTrue(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    public void givenIntervalClosedClosedWhenIncludeWithIncludedValueThenTrue() {
        Interval interval = intervalBuilder().closed(left.getEquals()).closed(right.getEquals()).build();
        assertFalse(interval.include(left.getLess()));
        assertTrue(interval.include(left.getEquals()));
        assertTrue(interval.include(left.getGreater()));

        assertTrue(interval.include(right.getLess()));
        assertTrue(interval.include(right.getEquals()));
        assertFalse(interval.include(right.getGreater()));
    }

    @Test
    public void givenIntervalOpenOpenWhenIntersectsWithIntersectedIntervalOpenOpenByTheLeftThenReturnTrue() {
        Interval interval = intervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
        Interval intersectedInterval = intervalBuilder().open(left.getLess()).open(left.getGreater()).build();
        assertTrue(interval.intersects(intersectedInterval));
    }

    @Test
    public void givenIntervalOpenOpenWhenIntersectsWithIntersectedIntervalOpenOpenByTheRightThenReturnTrue() {
        Interval interval = intervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
        Interval intersectedInterval = intervalBuilder().open(right.getLess()).open(right.getGreater()).build();
        assertTrue(interval.intersects(intersectedInterval));
    }

    @Test
    public void givenIntervalOpenOpenWhenIntersectsWithNotIntersectedIntervalOpenOpenByTheLeftThenReturnFalse() {
        Interval interval = intervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
        Interval intersectedInterval = intervalBuilder().open(left.getLess()).open(left.getEquals()).build();
        assertFalse(interval.intersects(intersectedInterval));
    }

    @Test
    public void givenIntervalOpenOpenWhenIntersectsWithNotIntersectedIntervalOpenOpenByTheRightThenReturnFalse() {
        Interval interval = intervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
        Interval intersectedInterval = intervalBuilder().open(right.getEquals()).open(right.getGreater()).build();
        assertFalse(interval.intersects(intersectedInterval));
    }

    @Test
    public void givenIntervalOpenOpenWhenIntersectsWithNotIntersectedIntervalOpenCloseByTheLeftThenReturnFalse() {
        Interval interval = intervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
        Interval intersectedInterval = intervalBuilder().open(left.getLess()).closed(left.getEquals()).build();
        assertFalse(interval.intersects(intersectedInterval));
    }

    @Test
    public void givenIntervalOpenOpenWhenIntersectsWithNotIntersectedIntervalCloseOpenByTheRightThenReturnFalse() {
        Interval interval = intervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
        Interval intersectedInterval = intervalBuilder().closed(right.getEquals()).open(right.getGreater()).build();
        assertFalse(interval.intersects(intersectedInterval));
    }

    @Test
    public void givenIntervalCloseOpenWhenIntersectsWithNotIntersectedIntervalOpenOpenByTheLeftThenReturnFalse() {
        Interval interval = intervalBuilder().closed(left.getEquals()).open(right.getEquals()).build();
        Interval intersectedInterval = intervalBuilder().open(left.getLess()).open(left.getEquals()).build();
        assertFalse(interval.intersects(intersectedInterval));
    }

    @Test
    public void givenIntervalOpenCloseWhenIntersectsWithNotIntersectedIntervalOpenOpenByTheRightThenReturnFalse() {
        Interval interval = intervalBuilder().open(left.getEquals()).closed(right.getEquals()).build();
        Interval intersectedInterval = intervalBuilder().open(right.getEquals()).open(right.getGreater()).build();
        assertFalse(interval.intersects(intersectedInterval));
    }

    @Test
    public void givenIntervalCloseOpenWhenIntersectsWithIntersectedIntervalCloseOpenByTheLeftThenReturnTrue() {
        Interval interval = intervalBuilder().closed(left.getEquals()).open(right.getEquals()).build();
        Interval intersectedInterval = intervalBuilder().open(left.getLess()).closed(left.getEquals()).build();
        assertTrue(interval.intersects(intersectedInterval));
    }

    @Test
    public void givenIntervalOpenCloseWhenIntersectsWithIntersectedIntervalCloseOpenByTheRightThenReturnTrue() {
        Interval interval = intervalBuilder().open(left.getEquals()).closed(right.getEquals()).build();
        Interval intersectedInterval = intervalBuilder().closed(right.getEquals()).open(right.getGreater()).build();
        assertTrue(interval.intersects(intersectedInterval));
    }

    @Test
    public void givenIntervalOpenOpenWhenIntersectsWithSameIntersectedIntervalOpenOpenThenReturnTrue() {
        Interval interval = intervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
        Interval intersectedInterval = intervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
        assertTrue(interval.intersects(intersectedInterval));
    }

    @Test
    public void givenIntervalOpenOpenWhenIntersectsWithIntervalOpenOpenThatFullyContainsIntervalThenReturnTrue() {
        Interval interval = intervalBuilder().open(left.getEquals()).closed(right.getEquals()).build();
        Interval intersectedInterval = intervalBuilder().open(left.getLess()).closed(right.getGreater()).build();
        assertTrue(interval.intersects(intersectedInterval));
    }

}