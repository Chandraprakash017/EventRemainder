
import java.util.Scanner;
import java.util.logging.ErrorManager;

import Service.EventManager;
import Model.Event;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EventManager manager = new EventManager();
        int choice;

        do {
            System.out.println("\n===== 📅 Event Reminder Menu =====");
            System.out.println("1. Add Event");
            System.out.println("2. View All Events");
            System.out.println("3. Delete Event");
            System.out.println("4. Check Today's Reminders");
            System.out.println("5. Exit");
            System.out.print("👉 Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // to avoid scanner issue

            switch (choice) {
                case 1:
                    System.out.print("📝 Title: ");
                    String title = sc.nextLine();
                    System.out.print("📝 Description: ");
                    String desc = sc.nextLine();
                    System.out.print("📆 Date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(sc.nextLine());
                    manager.addEvent(title, desc, date);
                    break;
                case 2:
                    manager.viewAllEvents();
                    break;
                case 3:
                    System.out.print("❓ Enter Event ID to delete: ");
                    int id = sc.nextInt();
                    manager.deleteEvent(id);
                    break;
                case 4:
                    manager.checkReminders();
                    break;
                case 5:
                    System.out.println("👋 Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("⚠️ Invalid choice! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}

