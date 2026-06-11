public class Test {
    public static void test1(){
        Month month = new Month();
        System.out.println("adding events to day 0");
        month.getDay(0).addEvent(new Event(270, 60));
        month.getDay(0).addEvent(new Event(360, 60));
        month.getDay(0).addEvent(new Event(480, 60));
        month.getDay(0).addEvent(new Event(1080, 60));


        for (Event event : month.getDay(0).listAllEvents()){
            System.out.println("Day 0 Event: "  + event.getStartTime() + " - " + event.getEndTime() + " " +  event.getTitle() + " " + event.getDescription());
        }
        System.out.println();



        System.out.println("adding events to day 1");
        month.getDay(1).addEvent(new Event(300, 60));
        month.getDay(1).addEvent(new Event(390, 60));
        month.getDay(1).addEvent(new Event(840, 60));

        for (Event event : month.getDay(1).listAllEvents()){
            System.out.println("Day 1 Event: "  + event.getStartTime() + " - " + event.getEndTime() + " " +  event.getTitle() + " " + event.getDescription());
        }
        System.out.println();

        System.out.println("Adding an event that overlaps with an existing event on day 0 at 300 for 30 minutes");
        month.getDay(0).addEvent(new Event(300, 30, "Baking"));
        for (Event event : month.getDay(0).listAllRemainingEvents(330)){
            System.out.println("Day 0 Event: "  + event.getStartTime() + " - " + event.getEndTime() + " " +  event.getTitle() + " " + event.getDescription());
        }
        System.out.println();

        System.out.println("Finding next available time slot on day 0 starting from 300 for 30 minutes then adding it as an event");
        Event available = month.getDay(0).nextAvailableTimeSlot(300, 30);
        System.out.println("Next Avaiable Event " + available.getStartTime() + " - " + available.getEndTime());
        month.getDay(0).addEvent(new Event(330, 30, "Baking"));
        System.out.println();
        
        System.out.println("Listing all remaining events on day 0 starting from 330");
        for (Event event : month.getDay(0).listAllRemainingEvents(330)){
            System.out.println("Day 0 Event: "  + event.getStartTime() + " - " + event.getEndTime() + " " +  event.getTitle() + " " + event.getDescription());
        }
        System.out.println();

        System.out.println("changing Baking to the next avaible time slot after 480 for 30 minutes");
        Event nextAvailable = month.getDay(0).nextAvailableTimeSlot(480, 30);
        month.getDay(0).getEvent(330).setStartTime(nextAvailable.getStartTime());
        for (Event event : month.getDay(0).listAllRemainingEvents(330)){
            System.out.println("Day 0 Event: "  + event.getStartTime() + " - " + event.getEndTime() + " " +  event.getTitle() + " " + event.getDescription());
        }
        System.out.println();

        System.out.println("Removing event new Event Baking from day 0");
        month.getDay(0).removeEvent(nextAvailable.getStartTime());
        for (Event event : month.getDay(0).listAllRemainingEvents(330)){
            System.out.println("Day 0 Event: "  + event.getStartTime() + " - " + event.getEndTime() + " " +  event.getTitle() + " " + event.getDescription());
        }


    
    
    }
}   
