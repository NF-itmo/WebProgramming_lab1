package org.web1;

import java.util.HashMap;
import java.util.function.Consumer;

import org.web1.http.RequestContext;
import org.web1.http.routing.EndpointKey;
import org.web1.http.routing.RestController;
import org.web1.http.handler.tester.Tester;


public class Application {
    public static void main(String[] args) {
        final HashMap<EndpointKey, Consumer<RequestContext>> endpoints = new HashMap<>();

        endpoints.put(
                new EndpointKey("GET", "/fcgi/"),
                new Tester()
        );

        new RestController(
                endpoints
        ).start();
    }
}