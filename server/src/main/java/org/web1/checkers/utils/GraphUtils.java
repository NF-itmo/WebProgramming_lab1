package org.web1.checkers.utils;

public class GraphUtils {
    public static GraphQuarters getQuarter(int x, float y) {
        boolean isXGraterOrEqualsZero = x >= 0;
        boolean isYGraterOrEqualsZero = y >= 0;

        if (isXGraterOrEqualsZero && isYGraterOrEqualsZero) return GraphQuarters.FIRST_QUADRANT;
        else if (!isXGraterOrEqualsZero && !isYGraterOrEqualsZero) return GraphQuarters.THIRD_QUADRANT;
        else if (!isXGraterOrEqualsZero && isYGraterOrEqualsZero) return GraphQuarters.SECOND_QUADRANT; // читабельность важнее
        return GraphQuarters.FOURTH_QUADRANT;
    }
}
