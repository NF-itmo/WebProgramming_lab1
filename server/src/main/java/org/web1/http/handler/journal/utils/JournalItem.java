package org.web1.http.handler.journal.utils;

public record JournalItem(
        long timestamp,
        long elapsedTimeNs,
        int x,
        float y,
        float r,
        boolean isInsideArea
) {
    @Override
    public String toString() {
        return String.format("""
                {
                    "timestamp": %s,
                    "elapsedTimeNs": %s,
                    "x": %s,
                    "y": %s,
                    "r": %s,
                    "isInsideArea": %s
                }
                """, timestamp, elapsedTimeNs, x, y, r, isInsideArea);
    }
}
