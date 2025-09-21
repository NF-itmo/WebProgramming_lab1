package org.web1.http.routing;

import com.fastcgi.FCGIInterface;
import org.web1.http.RequestContext;
import org.web1.utils.logging.SimpleLogger;
import org.web1.http.QueryStringParser;
import org.web1.http.response.HttpResponseWriter;

import java.util.HashMap;
import java.util.Properties;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.logging.Logger;

public class RestController {
    private static final Function<String, HashMap<String,String>> parseQuery = new QueryStringParser();
    private static final FCGIInterface fastCGI = new FCGIInterface();
    private static final Logger logger = SimpleLogger.create();
    private final HashMap<EndpointKey, Consumer<RequestContext>> endpoints;

    public RestController(HashMap<EndpointKey, Consumer<RequestContext>> endpoints) {
        this.endpoints = endpoints;
    }

    public void start() {
        HttpResponseWriter responseController = new HttpResponseWriter(logger);

        while (fastCGI.FCGIaccept() >= 0) {
            final Properties requestParams = FCGIInterface.request.params;

            final EndpointKey requestInfo = new EndpointKey(
                    requestParams.getProperty("REQUEST_METHOD"),
                    requestParams.getProperty("DOCUMENT_URI")
            );
            final HashMap<String, String> requestData = parseQuery.apply(
                            requestParams.getProperty("QUERY_STRING")
            );

            logger.info(requestInfo.method() + " " + requestInfo.path() + " " + requestData);

            Consumer<RequestContext> requestHandler = endpoints.get(requestInfo);

            if (requestHandler != null) requestHandler.accept(
                    new RequestContext(requestData, responseController)
            );
        }
    }
}
