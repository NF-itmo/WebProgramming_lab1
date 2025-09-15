package org.web1.checkers;

import java.util.HashMap;

@FunctionalInterface
public interface CheckerFunction {
    boolean test(int x, float y, float r);
}
