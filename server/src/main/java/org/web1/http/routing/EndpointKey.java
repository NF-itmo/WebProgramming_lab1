package org.web1.http.routing;

public record EndpointKey(
        String method,
        String path
) { }
