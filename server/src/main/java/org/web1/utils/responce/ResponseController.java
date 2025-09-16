package org.web1.utils.responce;

import org.web1.utils.mappers.JsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResponseController {
    private static final String BASE_RESPONSE = """
            Status: %s\r
            Access-Control-Allow-Origin: *\r
            Connection: keep-alive\r
            Content-Type: application/json; charset=utf-8\r
            Content-Length: %d\r
            \r
            %s""";

    private static final HashMap<ResponseStatus, String> responseStatus = new HashMap<>();
    private final Logger logger;

    static {
        responseStatus.put(ResponseStatus.BAD_REQUEST, "400");
        responseStatus.put(ResponseStatus.OK, "200");
    }

    public ResponseController(Logger logger) {
        this.logger = logger;
    }

    public void send(JsonBuilder jsonBuilder, ResponseStatus status) {
        String response = jsonBuilder.build();

        String out = String.format(
                BASE_RESPONSE,
                responseStatus.get(status),
                response.getBytes(StandardCharsets.UTF_8).length,
                response
        );

        logger.info("Sending response: " + out);

        System.out.println(out);
    }
}
