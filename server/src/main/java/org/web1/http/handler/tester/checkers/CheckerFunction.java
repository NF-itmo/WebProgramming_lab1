package org.web1.http.handler.tester.checkers;

import java.util.HashMap;

@FunctionalInterface
public interface CheckerFunction {
    boolean test(int x, float y, float r);
}
