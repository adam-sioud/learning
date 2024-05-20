package oving5;

import java.time.LocalDateTime;

public class PeriodTicket implements Ticket {

    private final LocalDateTime start;
    private final LocalDateTime end;

    public PeriodTicket(LocalDateTime start, LocalDateTime end) {
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }

        this.start = start;
        this.end = end;
    }

    @Override
    public boolean scan() {
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(start) && now.isBefore(end);
    }
}
