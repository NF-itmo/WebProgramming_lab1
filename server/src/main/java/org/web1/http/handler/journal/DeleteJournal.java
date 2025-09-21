package org.web1.http.handler.journal;

import org.web1.http.RequestContext;
import org.web1.http.handler.journal.utils.Journal;
import org.web1.http.response.ResponseStatus;
import org.web1.utils.json.JsonBuilder;

import java.util.function.Consumer;

public class DeleteJournal implements Consumer<RequestContext> {
    private final Journal journal;

    public DeleteJournal(Journal journal) {
        this.journal = journal;
    }

    @Override
    public void accept(
            final RequestContext endpointData
    ) {
        this.journal.clear();
        endpointData.responseController().send(
                new JsonBuilder().add("status", "\"Completed!\""),
                ResponseStatus.OK
        );
    }
}