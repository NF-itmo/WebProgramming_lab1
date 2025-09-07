package org.web1.utils;

import java.util.HashMap;

public class JsonBuilder {
    private final HashMap<String, String> data = new HashMap<>();

    public <T> JsonBuilder add(String key, T value) {
        this.data.put(key, value.toString());
        return this;
    }

    public String build() {
        StringBuilder jsonString = new StringBuilder("{\n");

        for (String key : data.keySet())
            jsonString.append(String.format("\t%s: %s,\n", key, data.get(key)));

        return jsonString + "}";
    }
}
