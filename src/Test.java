public class Test {

    public static void main(String[] args) throws Exception {
        Test.test1();
        Test.test2();
        Test.test3();
        Test.test4();
        
    }


    public static void test1() { // this test is to check listing all events and listing all remaining events for a given start time and a given day
        System.out.println("== Test 1 ==");
        Month month = new Month();
        System.out.println("adding events to day 0");
        month.getDay(0).addEvent(new Event(270, 60));
        month.getDay(0).addEvent(new Event(360, 60));
        month.getDay(0).addEvent(new Event(480, 60));
        month.getDay(0).addEvent(new Event(1080, 60));

        System.out.println("adding events to day 1");
        month.getDay(1).addEvent(new Event(330, 30));
        month.getDay(1).addEvent(new Event(420, 90));
        month.getDay(1).addEvent(new Event(540, 60));
        month.getDay(1).addEvent(new Event(1300, 60));
        System.out.println();

        System.out.println("Listing all events on day 0");
        for (Event event : month.getDay(0).listAllEvents()) {
            System.out.println("Day 0 Event: " + event.getStartTime() + " - " + event.getEndTime() + " "
                    + event.getTitle() + " " + event.getDescription());
        }
        System.out.println();

        System.out.println("Listing all events on day 1");
        for (Event event : month.getDay(1).listAllEvents()) {
            System.out.println("Day 1 Event: " + event.getStartTime() + " - " + event.getEndTime() + " "
                    + event.getTitle() + " " + event.getDescription());
        }
        System.out.println();

        System.out.println("Listing all remaining events on day 0 starting from 400");
        for (Event event : month.getDay(0).listAllRemainingEvents(400)) {
            System.out.println("Day 0 Event: " + event.getStartTime() + " - " + event.getEndTime() + " "
                    + event.getTitle() + " " + event.getDescription());
        }
        System.out.println();

        System.out.println("Listing all remaining events on day 1 starting from 800");
        for (Event event : month.getDay(1).listAllRemainingEvents(800)) {
            System.out.println("Day 1 Event: " + event.getStartTime() + " - " + event.getEndTime() + " "
                    + event.getTitle() + " " + event.getDescription());
        }
    }

    public static void test2() { // This test is to check the remove event functionality and that the events are listed in order of start time
        System.out.println("== Test 2 ==");
        Month month = new Month();
        System.out.println("adding events to day 0");
        month.getDay(0).addEvent(new Event(270, 60));
        month.getDay(0).addEvent(new Event(360, 60));
        month.getDay(0).addEvent(new Event(480, 60));
        month.getDay(0).addEvent(new Event(1080, 60));

        System.out.println("Listing all events on day 0");
        for (Event event : month.getDay(0).listAllEvents()) {
            System.out.println("Day 0 Event: " + event.getStartTime() + " - " + event.getEndTime() + " "
                    + event.getTitle() + " " + event.getDescription());
        }

        System.out.println();
        System.out.println("Removing event at 360 from day 0");
        System.out.println();
        month.getDay(0).removeEvent(360);
         System.out.println("Listing all events on day 0");
        for (Event event : month.getDay(0).listAllEvents()) {
            System.out.println("Day 0 Event: " + event.getStartTime() + " - " + event.getEndTime() + " "
                    + event.getTitle() + " " + event.getDescription());
        }
    }

    public static void test3() { // This test is to check conflicts when adding events
        System.out.println("== Test 3 ==");
        Month month = new Month();
        System.out.println("adding events to day 0");
        month.getDay(0).addEvent(new Event(270, 60));
        month.getDay(0).addEvent(new Event(360, 60));
        month.getDay(0).addEvent(new Event(480, 60));
        month.getDay(0).addEvent(new Event(1080, 60));

        System.out.println("Listing all events on day 0");
        for (Event event : month.getDay(0).listAllEvents()) {
            System.out.println("Day 0 Event: " + event.getStartTime() + " - " + event.getEndTime() + " "
                    + event.getTitle() + " " + event.getDescription());
        }
        System.out.println();
        System.out.println("Adding an event that overlaps with an existing event on day 0 at 300 for 80 minutes");
        System.out.println("Adding an event that overlaps with an existing event on day 0 at 480 for 60 minutes");
        System.out.println("Adding an event that overlaps with an existing event on day 0 at 1140 for 60 minutes");
        System.out.println("two of the events should not be added because they overlap with existing events and one should be added because it does not overlap with any existing events");
        System.out.println();

        month.getDay(0).addEvent(new Event(300, 80, "Cleaning"));
        month.getDay(0).addEvent(new Event(480, 60, "Soccer"));
        month.getDay(0).addEvent(new Event(1140, 60, "Dinner"));

        System.out.println("Listing all events on day 0");
        for (Event event : month.getDay(0).listAllEvents()) {
            System.out.println("Day 0 Event: " + event.getStartTime() + " - " + event.getEndTime() + " "
                    + event.getTitle() + " " + event.getDescription());
        }
    }
    public static void test4() { // This test it to modify the events to have a title and description 
        System.out.println("== Test 4 ==");
        Month month = new Month();
        System.out.println("adding events to day 0");
        month.getDay(0).addEvent(new Event(270, 60));
        month.getDay(0).addEvent(new Event(360, 60));
        month.getDay(0).addEvent(new Event(480, 60));
        month.getDay(0).addEvent(new Event(1080, 60));

        System.out.println("Listing all events on day 0");
        for (Event event : month.getDay(0).listAllEvents()) {
            System.out.println("Day 0 Event: " + event.getStartTime() + " - " + event.getEndTime() + " "
                    + event.getTitle() + " " + event.getDescription());
        }

        System.out.println();
        System.out.println("modifying event at 360 from day 0 to have a title and description");
        month.getDay(0).getEvent(360).setDescription("DevOps Standup");
        month.getDay(0).getEvent(360).setTitle("Team Meeting");

        System.out.println("modifying event at 480 from day 0 to have a title and description");
        month.getDay(0).getEvent(480).setDescription("Eggs and bacon");
        month.getDay(0).getEvent(480).setTitle("Breakfast");

        System.out.println();
        System.out.println("Listing all events on day 0");
        for (Event event : month.getDay(0).listAllEvents()) {
            System.out.println("Day 0 Event: " + event.getStartTime() + " - " + event.getEndTime() + " "
                    + event.getTitle() + " " + event.getDescription());
        }

    }
}
