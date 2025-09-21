package org.web1;

import java.util.HashMap;
import java.util.function.Consumer;

import org.web1.http.RequestContext;
import org.web1.http.handler.journal.DeleteJournal;
import org.web1.http.handler.journal.GetJournal;
import org.web1.http.handler.journal.utils.Journal;
import org.web1.http.routing.EndpointKey;
import org.web1.http.routing.RestController;
import org.web1.http.handler.tester.Tester;


public class Application {
    public static void main(String[] args) {
        final HashMap<EndpointKey, Consumer<RequestContext>> endpoints = new HashMap<>();

        final Journal journal = new Journal();

        endpoints.put(
                new EndpointKey("GET", "/fcgi/test"),
                new Tester(journal)
        );
        endpoints.put(
                new EndpointKey("DELETE", "/fcgi/journal"),
                new DeleteJournal(journal)
        );
        endpoints.put(
                new EndpointKey("GET", "/fcgi/journal"),
                new GetJournal(journal)
        );

        new RestController(
                endpoints
        ).start();
    }
}