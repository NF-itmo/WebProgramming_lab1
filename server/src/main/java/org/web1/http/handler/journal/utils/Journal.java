package org.web1.http.handler.journal.utils;

import java.util.ArrayList;

public class Journal {
    private final ArrayList<JournalItem> journal = new ArrayList<>();

    public ArrayList<JournalItem> get() {
        return journal;
    }

    public void append(JournalItem journalItem) {
        journal.add(journalItem);
    }

    public void clear() {
        journal.clear();
    }
}