package Model;


import java.time.LocalDate;

public class Event implements Comparable<Event> {
    public int id;
    public String title;
    public String description;
    public LocalDate date;

    public Event(int id, String title, String description, LocalDate date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    @Override
    public int compareTo(Event other) {
        return this.date.compareTo(other.date);
    }

    @Override
    public String toString() {
        return "📅 " + date + " | " + title + " (ID: " + id + ")";
    }
}

