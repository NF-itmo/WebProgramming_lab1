package org.web1.checkers;
import org.web1.checkers.utils.GraphQuarters;
import org.web1.checkers.utils.GraphUtils;

import java.util.HashMap;

public class Checker implements CheckerFunction{
    public boolean test(HashMap<String, String> data) {
        int x = Integer.parseInt(data.get("x"));
        float y = Float.parseFloat(data.get("y"));
        float r = Float.parseFloat(data.get("r"));

        final GraphQuarters quarter = GraphUtils.getQuarter(x, y);

        if (quarter == GraphQuarters.FIRST_QUADRANT) return firstQuarterTester(x, y, r);
        else if (quarter == GraphQuarters.SECOND_QUADRANT) return secondQuarterTester(x, y, r);
        else if (quarter == GraphQuarters.THIRD_QUADRANT) return thirdQuarterTester(x, y, r);
        return forthQuarterTester(x, y, r);
    }

    private boolean firstQuarterTester(int x, float y, float r) {
        return x <= r/2 && y <= r;
    }

    private boolean secondQuarterTester(int x, float y, float r) {
        return y <= (r/2 + 0.5f*x);
    }

    private boolean thirdQuarterTester(int x, float y, float r) {
        return false;
    }

    private boolean forthQuarterTester(int x, float y, float r) {
        return Math.sqrt(x*x + y*y) <= r/2;
    }
}