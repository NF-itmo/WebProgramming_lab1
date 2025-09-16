package org.web1.checkers;
import org.web1.checkers.utils.PlotQuarters;
import org.web1.checkers.utils.PlotUtils;

public class Checker implements CheckerFunction{
    public boolean test(final int x, final float y, final float r) {
        final PlotQuarters quarter = PlotUtils.getQuarter(x, y);

        if (quarter == PlotQuarters.FIRST_QUADRANT) return firstQuarterTester(x, y, r);
        else if (quarter == PlotQuarters.SECOND_QUADRANT) return secondQuarterTester(x, y, r);
        else if (quarter == PlotQuarters.THIRD_QUADRANT) return thirdQuarterTester(x, y, r);
        return forthQuarterTester(x, y, r);
    }

    private boolean firstQuarterTester(final int x, final float y, final float r) {
        return x <= r / 2 && y <= r;
    }

    private boolean secondQuarterTester(final int x, final float y, final float r) {
        return y <= (r / 2 + 0.5f * x);
    }

    private boolean thirdQuarterTester(final int x, final float y,final float r) {
        return false;
    }

    private boolean forthQuarterTester(final int x, final float y, final float r) {
        return Math.sqrt(x * x + y * y) <= r / 2;
    }
}