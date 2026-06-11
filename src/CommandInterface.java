import java.util.Scanner;

public class CommandInterface {
    static Scanner scanner;
    static Month month;

    public static void main(String[] args) throws Exception {
        month = new Month(); // create a month with 30 days
        scanner = new Scanner(System.in); // create a scanner for user input
        System.out.println("=====================Calender manager=====================");
        while (true) {
            // Menu
            System.out.println(
                    "1. List all dates \n" +
                            "2. List all Events for a Date \n" +
                            "3. List all Remaining Events for a Date \n" +
                            "4. Add an Event \n" +
                            "5. Remove an Event \n" +
                            "6. Modify an Event \n" +
                            "7. Next avaible timeslot for a day");
            System.out.print("choose an option:");
            switch (nextInt()) {
                case 1:
                    listAllDates();
                    break;
                case 2:
                    listAllEvents();
                    break;
                case 3:
                    listAllRemainingEvents();
                    break;
                case 4:
                    addEvent();
                    break;
                case 5:
                    removeEvent();
                    break;
                case 6:
                    modifyEvent();
                    break;
                case 7:
                    nextAvaibleEvent();
                    break;
                default:
                    System.out.print("Invalid option, please try again.");
                    Thread.sleep(1000);
            }
            System.out.println();
            System.out.println();

        }
    }

    private static void listAllDates() {
        System.out.println();
        for (int i = 0; i < month.getDays().length; i++) {
            System.out.println("Day " + i + ": " + (month.getDay(i).listAllEvents().size() - 2) + " events"); // subtract
                                                                                                              // 2 to
                                                                                                              // account
                                                                                                              // for the
                                                                                                              // default
                                                                                                              // start
                                                                                                              // and end
                                                                                                              // of day
                                                                                                              // events1
        }

        System.out.print("enter any key to continue");
        scanner.next();
    }

    private static void listAllEvents() {
        System.out.println();
        System.out.print("Enter the day number to list events for:");
        int dayNumber = nextInt();
        System.out.println();

        if (dayNumber >= 0 && dayNumber < month.getDays().length) {
            for (Event event : month.getDay(dayNumber).listAllEvents()) {
                System.out.println("Day " + dayNumber + ": " + event.getStartTime() + " - " + event.getEndTime() + " "
                        + event.getTitle() + " " + event.getDescription());
            }
        } else {
            System.out.println("Invalid day number, please try again.");
        }

        System.out.print("enter any key to continue");
        scanner.next();

    }

    private static void listAllRemainingEvents() {
        System.out.println();
        System.out.print("Enter the day number to list remaining events for:");
        int dayNumber = nextInt();
        System.out.print("Enter the start time to list remaining events from:");
        int startTime = nextInt();

        if (dayNumber >= 0 && dayNumber < month.getDays().length) {
            for (Event event : month.getDay(dayNumber).listAllRemainingEvents(startTime)) {
                System.out.println("Day " + dayNumber + ": " + event.getStartTime() + " - " + event.getEndTime() + " "
                        + event.getTitle() + " " + event.getDescription());
            }
        } else {
            System.out.println("Invalid day number, please try again.");
        }

        System.out.print("enter any key to continue");
        scanner.next();
    }

    private static void addEvent() {
        System.out.println();
        while (true) {
            System.out.print("Enter the day number to add an event to:");
            int dayNumber = nextInt();
            if (dayNumber >= 0 && dayNumber < month.getDays().length) {
                System.out.println();
                System.out.println("Events: ");
                for (Event event : month.getDay(dayNumber).listAllEvents()) {
                    System.out.println("Day " + dayNumber + ": " + event.getStartTime() + " - " + event.getEndTime()
                            + " " + event.getTitle() + " " + event.getDescription());
                }
            } else {
                System.out.println("Invalid day number, please try again.");
                continue;
            }

            System.out.print("Enter the start time for the event:");
            int startTime = nextInt();
            System.out.print("Enter the duration for the event:");
            int duration = nextInt();
            System.out.print("Enter the title for the event:");
            String title = scanner.next();
            System.out.print("Enter the description for the event:");
            String description = scanner.next();
            System.out.println();

            Event newEvent = new Event(startTime, duration, title, description);
            if (month.getDay(dayNumber).ConflictingEventExists(newEvent)) {
                System.out.println("An event already exists at this time, please try again.");
                continue;
            }

            if (dayNumber >= 0 && dayNumber < month.getDays().length) {
                month.getDay(dayNumber).addEvent(newEvent);
                System.out.println("Event added successfully.");
                break;
            } else {
                System.out.println("Invalid day number, please try again.");
            }
        }
        System.out.print("enter any key to continue");
        scanner.next();
    }

    private static void removeEvent() {
        System.out.println();

        while (true) {
            System.out.print("Enter the day number to remove an event from:");
            int dayNumber = nextInt();
            if (dayNumber >= 0 && dayNumber < month.getDays().length) {
                System.out.println();
                System.out.println("Events: ");
                for (Event event : month.getDay(dayNumber).listAllEvents()) {
                    System.out.println("Day " + dayNumber + ": " + event.getStartTime() + " - " + event.getEndTime()
                            + " " + event.getTitle() + " " + event.getDescription());
                }
                System.out.println();
            } else {
                System.out.println("Invalid day number, please try again.");
                continue;
            }
            System.out.print("Enter the start time of the event to remove:");
            int startTime = nextInt();
            if (month.getDay(dayNumber).isEventScheduled(startTime)) {
                month.getDay(dayNumber).removeEvent(startTime);
                System.out.println("Event removed successfully.");
                break;
            } else {
                System.out.println("No event scheduled at this time, please try again.");
            }

        }
    }

    private static void modifyEvent() {
        System.out.println();
        System.out.print("Enter the day number to modify an event to:");
        int dayNumber = nextInt();
        if (dayNumber >= 0 && dayNumber < month.getDays().length) {
            System.out.println();
            System.out.println("Events: ");
            for (Event event : month.getDay(dayNumber).listAllEvents()) {
                System.out.println("Day " + dayNumber + ": " + event.getStartTime() + " - " + event.getEndTime()
                        + " " + event.getTitle() + " " + event.getDescription());
            }
        } else {
            System.out.println("Invalid day number, please try again.");
           return;
        }
        System.out.print("Enter the start time of the event to modify:");
        int startTime = nextInt();
        System.out.println();
        if (!month.getDay(dayNumber).isEventScheduled(startTime)) {
            System.out.println("No event scheduled at this time, please try again.");
            return;// restart the menu
        }

        Event modifiedEvent;

        while (true) {
            System.out.println();
            System.out.println(
                    "1. Change start time \n" +
                            "2. Change duration \n" +
                            "3. Change title \n" +
                            "4. Change description \n" +
                            "5. Finish");
            System.out.println();           
            System.out.print("choose an option:");
            switch (nextInt()) {
                case 1:
                    System.out.print("Enter the new start time:");
                    int newStartTime = nextInt();
                    System.out.println();

                    //check for conflict
                    modifiedEvent = new Event(newStartTime, month.getDay(dayNumber).getEvent(startTime).getDuration());
                    for(Event event : month.getDay(dayNumber).listAllEvents()){
                        if (event.getStartTime() == startTime){
                            continue; // skip the event being modified
                        }
                        if (event.overlapsWith(modifiedEvent) && event.getStartTime() != startTime){
                            System.out.println("new Time overlaps with an existing event, please try again.");
                            continue;
                        }
                    }

                    month.getDay(dayNumber).getEvent(startTime).setStartTime(newStartTime);
                    break;
                case 2:
                    System.out.print("Enter the new duration:");
                    int newDuration = nextInt();
                    System.out.println();

                    //check for conflict
                    modifiedEvent = new Event(startTime, newDuration);
                    for(Event event : month.getDay(dayNumber).listAllEvents()){
                        if (event.getStartTime() == startTime){
                            continue; // skip the event being modified
                        }
                        if (event.overlapsWith(modifiedEvent) && event.getStartTime() != startTime){
                            System.out.println("new duration overlaps with an existing event, please try again.");
                            continue;
                        }
                    }

                    month.getDay(dayNumber).getEvent(startTime).setDuration(newDuration);
                    break;
                case 3:
                    System.out.print("Enter the new title:");
                    String newTitle = scanner.nextLine();
                    System.out.println();

                    month.getDay(dayNumber).getEvent(startTime).setTitle(newTitle);
                    break;
                case 4:
                    System.out.print("Enter the new description:");
                    String newDescription = scanner.nextLine();
                    System.out.println();

                    month.getDay(dayNumber).getEvent(startTime).setDescription(newDescription);
                    break;
                case 5:
                    return;
                default:
                    System.out.print("Invalid option, please try again.");
            }
            break;
        }

    }


    private static void nextAvaibleEvent() {
        System.out.println();
        int dayNumber;
        while (true) {
            System.out.print("Enter the day number to find the next available time slot for:");
            dayNumber = nextInt();
            if (dayNumber >= 0 && dayNumber < month.getDays().length) {
                System.out.println();
                System.out.println("Events: ");
                for (Event event : month.getDay(dayNumber).listAllEvents()) {
                    System.out.println("Day " + dayNumber + ": " + event.getStartTime() + " - " + event.getEndTime()
                            + " " + event.getTitle() + " " + event.getDescription());
                }
                break;
            } else {
                System.out.println("Invalid day number, please try again.");
                continue;
            }
           
    
        }
        System.out.print("Enter the start time to find the next available time slot from:");
        int startTime = nextInt();
        System.out.print("Enter the duration for the event:");
        int duration = nextInt();
        Event available = month.getDay(dayNumber).nextAvailableTimeSlot(startTime, duration);
        if (available.getDuration() == 0) {
            System.out.println("No available time slot found.");
            return;
        }
        System.out.println("Next Available Event: " + available.getStartTime() + " - " + available.getEndTime());
        System.out.println();

        while(true){
            System.out.print("Do you want to add an event? (y/n)");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("y")) {
                // Add event logic here
                break;
            } else if (input.equalsIgnoreCase("n")) {
                return;
            } else {
                System.out.println("Invalid input, please enter 'y' or 'n'.");
            }
        }

        while (true) {
            System.out.print("Enter the start time for the event:");
            startTime = nextInt();
            System.out.print("Enter the duration for the event:");
            duration = nextInt();
            System.out.print("Enter the title for the event:");
            String title = scanner.next();
            System.out.print("Enter the description for the event:");
            String description = scanner.next();
            System.out.println();

            Event newEvent = new Event(startTime, duration, title, description);
            if (month.getDay(dayNumber).ConflictingEventExists(newEvent)) {
                System.out.println("An event already exists at this time, please try again.");
                continue;
            }

            if (dayNumber >= 0 && dayNumber < month.getDays().length) {
                month.getDay(dayNumber).addEvent(newEvent);
                System.out.println("Event added successfully.");
                break;
            } else {
                System.out.println("Invalid day number, please try again.");
            }
        }


    }

    private static int nextInt() {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (Exception e) {
                System.out.println();
                System.out.print("Invalid input, please enter a number:");
            }
        }
    }
}
