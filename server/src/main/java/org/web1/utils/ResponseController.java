package org.web1.utils;

public class ResponseController {
    private static final String BASE_RESPONSE = """
            Access-Control-Allow-Origin: *
            Connection: keep-alive
            Content-Type: application/json
            Content-Length: %d
            
            %s""";
    public static String create(JsonBuilder jsonBuilder) {
        String response = jsonBuilder.build();
        return String.format(BASE_RESPONSE, response.length(), response);
    }
}
