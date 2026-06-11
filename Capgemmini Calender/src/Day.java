import java.util.ArrayList;

public class Day {
    private ArrayList<Events> events;
    
    public Day(){

    }
    
    public ArrayList<Events> listAllEvents(){
        return events;
    }

    public ArrayList<Events> listAllRemainingEvents(int[] startTime){
        
        // filter events based on the provided start time
        return events;

    }

    public void addEvent(Events event){
        events.add(event);
    }

    public void removeEvent(Events event){
        events.remove(event);
    }

    public void nextAvaibleTimeSlot(int[] startTime, int durationMinutes){
        // logic to find the next available time slot based on the existing events and the provided duration
    }
}
