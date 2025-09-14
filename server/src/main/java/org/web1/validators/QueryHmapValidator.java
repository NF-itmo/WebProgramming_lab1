package org.web1.validators;

import java.util.HashMap;
import java.util.function.Function;

public class QueryHmapValidator implements Function<HashMap<String, String>, Boolean> {
    public Boolean apply(HashMap<String, String> data) {
        try {
            Integer.parseInt(data.get("x"));
            Float.parseFloat(data.get("y"));
            Float.parseFloat(data.get("r"));

            return true;
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
    }
}
