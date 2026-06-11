import java.util.ArrayList;

public class Day {
    private ArrayList<Event> events;
    
    public Day(){
        events = new ArrayList<Event>();
        events.add(new Event(0,0, "Start of day"));
        events.add(new Event(1440,0, "End of day"));
    }
    
    public ArrayList<Event> listAllEvents(){
        return events;
    }

    public ArrayList<Event> listAllRemainingEvents(int startTime){
        ArrayList<Event> remainingEvents = new ArrayList<Event>();
        for (Event event : events){
            if (event.getStartTime() >= startTime){
                remainingEvents.add(event); 
            }
        }
        return remainingEvents;
    }

    public void addEvent(Event event){
        for(Event existingEvent : events){
            if (existingEvent.overlapsWith(event)){
                return; // do not add the event if it overlaps with an existing event
            }
        }
        events.add(event);
    }

    public void removeEvent(Event event){
        events.remove(event);
    }

    public Event nextAvailableTimeSlot(int startTime, int duration){
        events.sort((e1, e2) -> Integer.compare(e1.getStartTime(), e2.getStartTime())); // sort events by start time
        for (int i = 0; i < events.size()-1; i++){
            if(events.get(i).getEndTime() >= startTime && events.get(i+1).getStartTime() >= startTime + duration){
                return new Event(events.get(i).getEndTime(), duration); // return the next available time slot as an event
            }

        }
        return new Event(0, 0); // return a default event if no available time slot is found
    }
}
