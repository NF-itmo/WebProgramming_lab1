package org.web1.http.handler.tester.checkers.utils;

public class PlotUtils {
    public static PlotQuarters getQuarter(final int x, final float y) {
        boolean isXGraterOrEqualsZero = x >= 0;
        boolean isYGraterOrEqualsZero = y >= 0;

        if (isXGraterOrEqualsZero && isYGraterOrEqualsZero) return PlotQuarters.FIRST_QUADRANT;
        else if (!isXGraterOrEqualsZero && !isYGraterOrEqualsZero) return PlotQuarters.THIRD_QUADRANT;
        else if (!isXGraterOrEqualsZero && isYGraterOrEqualsZero) return PlotQuarters.SECOND_QUADRANT; // читабельность важнее
        return PlotQuarters.FOURTH_QUADRANT;
    }
}
