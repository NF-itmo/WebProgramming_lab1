package org.web1.utils;

import java.util.HashMap;
import java.util.function.Function;

public class QueryStringToHashmap implements Function<String, HashMap<String,String>> {
    public HashMap<String, String> apply(String jsonStr) {
        HashMap<String, String> params = new HashMap<>();

        String[] pairs = jsonStr.split("&"); // get key+value pairs string

        for (String pair : pairs) {

            String[] keyValue = pair.split("="); // get key+value pairs arrays. first elem - key, second - value

            if (keyValue.length > 1) params.put(keyValue[0], keyValue[1]);
            else  params.put(keyValue[0], "");
        }

        return params;
    }

}
