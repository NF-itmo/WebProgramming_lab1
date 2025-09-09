package org.web1.checkers;

import java.util.HashMap;

@FunctionalInterface
public interface CheckerFunction {
    boolean test(HashMap<String, String> data);
}
