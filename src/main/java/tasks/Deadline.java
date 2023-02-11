package tasks;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Deadline extends Task {
    protected String deadline;

    protected LocalDate date;
    protected LocalTime time = null;

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
        handleDateAndTime();
    }

    public void handleDateAndTime() {
        if (deadline.contains(" ")) {
            LocalDate newDate = LocalDate.parse(deadline.split(" ")[0]);
            LocalTime newTime = LocalTime.parse(deadline.split(" ")[1]);
            this.date = newDate;
            this.time = newTime;
        }
        else {
            LocalDate newDate = LocalDate.parse(deadline);
            this.date = newDate;
        }
    }

    public String printDateAndTime() {
        if (time.equals(null)) {
            return date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        }
        else {
            return date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + Integer.toString(time.getHour()) + Integer.toString(time.getMinute());
        }
    }
    @Override
    public String toString() {
        return "[D]" + "[" + this.getStatusIcon() + "] " + this.description + " (by: " + deadline + ")";
    }
}
