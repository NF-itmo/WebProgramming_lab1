package org.web1.http.handler.journal;

import org.web1.http.RequestContext;
import org.web1.http.handler.journal.utils.Journal;
import org.web1.http.handler.journal.utils.JournalItem;
import org.web1.http.response.ResponseStatus;
import org.web1.utils.json.JsonBuilder;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class GetJournal implements Consumer<RequestContext> {
    private final Journal journal;

    public GetJournal(Journal journal) {
        this.journal = journal;
    }

    @Override
    public void accept(
            final RequestContext endpointData
    ) {
        endpointData.responseController().send(
                new JsonBuilder().add(
                        "result",
                        "[" + journal.get().stream()
                                .map(JournalItem::toString)
                                .collect(Collectors.joining(",")) + "]"
                ),
                ResponseStatus.OK
        );
    }
}