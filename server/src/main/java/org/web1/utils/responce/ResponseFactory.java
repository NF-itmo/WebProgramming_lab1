package org.web1.utils.responce;

import org.web1.utils.mappers.JsonBuilder;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class ResponseFactory {
    private static final String BASE_RESPONSE = """
            HTTP/2 %s\r
            Status: %s\r
            Access-Control-Allow-Origin: *\r
            Connection: keep-alive\r
            Content-Type: application/json; charset=utf-8\r
            Content-Length: %d\r
            \r
            %s""";

    private static final HashMap<ResponseStatus, String> responseStatus = new HashMap<>();

    static {
        responseStatus.put(ResponseStatus.BAD_REQUEST, "400");
        responseStatus.put(ResponseStatus.OK, "200");
    }

    public static String create(JsonBuilder jsonBuilder, ResponseStatus status) {
        String response = jsonBuilder.build();

        return String.format(
                BASE_RESPONSE,
                responseStatus.get(status),
                responseStatus.get(status),
                response.getBytes(StandardCharsets.UTF_8).length + 1,
                response
        );
    }
}
