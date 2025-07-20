
package Service;

import Model.Event; // ✅ because we are using Event class inside EventManager

import java.util.*;

import java.time.LocalDate;

public class EventManager {
    private PriorityQueue<Event> eventQueue;
    private HashMap<Integer, Event> eventMap;
    private int nextId = 1;

    public EventManager() {
        eventQueue = new PriorityQueue<>();
        eventMap = new HashMap<>();
    }

    public void addEvent(String title, String desc, LocalDate date) {
        Event e = new Event(nextId, title, desc, date);
        eventQueue.add(e);
        eventMap.put(nextId, e);
        System.out.println("✅ Event added with ID: " + nextId);
        nextId++;
    }

    public void viewAllEvents() {
        if (eventQueue.isEmpty()) {
            System.out.println("❌ No events found.");
            return;
        }
        for (Event e : eventQueue) {
            System.out.println(e);
        }
    }

    public void deleteEvent(int id) {
        if (!eventMap.containsKey(id)) {
            System.out.println("❌ Event not found!");
            return;
        }
        Event e = eventMap.get(id);
        eventQueue.remove(e);
        eventMap.remove(id);
        System.out.println("🗑️ Event deleted.");
    }

    public void checkReminders() {
        LocalDate today = LocalDate.now();
        for (Event e : eventQueue) {
            if (e.date.isEqual(today)) {
                System.out.println("🔔 Reminder: Today is " + e.title);
            }
        }
    }
}
