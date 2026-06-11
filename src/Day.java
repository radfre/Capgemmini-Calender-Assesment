import java.util.ArrayList;

public class Day {
    private ArrayList<Event> events;
    
    public Day(){
        events = new ArrayList<Event>();
        events.add(new Event(0,0, "Start of day"));
        events.add(new Event(1440,0, "End of day"));
        events.add(new Event(500,30, "Test"));
    }
    
    public ArrayList<Event> listAllEvents(){
        events.sort((e1, e2) -> Integer.compare(e1.getStartTime(), e2.getStartTime())); // sort events by start time
        return events;
    }

    public ArrayList<Event> listAllRemainingEvents(int startTime){
        events.sort((e1, e2) -> Integer.compare(e1.getStartTime(), e2.getStartTime())); // sort events by start time
        ArrayList<Event> remainingEvents = new ArrayList<Event>();
        for (Event event : events){
            if (event.getStartTime() >= startTime){
                remainingEvents.add(event); 
            }
        }
        return remainingEvents;
    }

    public Event getEvent(int startTime){
        for (Event event : events){
            if (event.getStartTime() == startTime){
                return event; // return the event if it matches the start time and duration
            }
        }
        return null; // return null if no matching event is found
    }

    public void addEvent(Event event){
        for(Event existingEvent : events){
            if (existingEvent.overlapsWith(event)){
                return; // do not add the event if it overlaps with an existing event
            }
        }
        events.add(event);
    }

    public void removeEvent(int startTime){
        for (Event event : events){
            if (event.getStartTime() == startTime){
                events.remove(event);
                return;
            }
        }
        
    }

    public boolean isEventScheduled(int startTime){
        for(Event existingEvent : events){
            if (existingEvent.getStartTime() == startTime){
                return true; // return true if an event is scheduled at the given start time
            }
        }
        return false; // return false if no overlapping event is found
    }

    public Event nextAvailableTimeSlot(int startTime, int duration){
        events.sort((e1, e2) -> Integer.compare(e1.getStartTime(), e2.getStartTime())); // sort events by start time
        for (int i = 0; i < events.size()-1; i++){
            if(startTime + duration <= events.get(i+1).getStartTime() && startTime >= events.get(i).getEndTime()){
                return new Event(events.get(i).getEndTime(), events.get(i+1).getStartTime());
            }


        }
        return new Event(0, 0); // return a default event if no available time slot is found
    }

    public boolean ConflictingEventExists(Event event){
        for(Event existingEvent : events){
            if (existingEvent.overlapsWith(event)){
                return true; // return true if an event overlaps with the given start time and duration
            }
        }
        return false; // return false if no overlapping event is found
    }
}
