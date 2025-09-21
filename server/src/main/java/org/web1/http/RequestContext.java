package org.web1.http;

import org.web1.http.response.HttpResponseWriter;

import java.util.HashMap;

public record RequestContext(
       HashMap<String, String> queryParams,
       HttpResponseWriter responseController
) {}
