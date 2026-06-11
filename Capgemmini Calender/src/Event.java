public class Event {
    private int startTime;
    private int duration;
    // time is represented in minutes from the start of the day (e.g., 0 for 12:00 AM, 60 for 1:00 AM, etc.)

    public Event(int startTime, int duration){
        // constructor logic to initialize the event with the provided start time and duration
        this.startTime = startTime;
        this.duration = duration;
    }

    public int getStartTime(){
        return startTime;
    }
    public int getDuration(){
        return duration;
    }
    public int getEndTime(){
        int endTime = startTime + duration; // calculate end time based on start time and duration
        return endTime; // return the calculated end time
    }
    public boolean overlapsWith(Event otherEvent){
        if (this.getStartTime() < otherEvent.getEndTime() && this.getEndTime() > otherEvent.getStartTime()) {
            return true; // events overlap
        }
        return false; // events do not overlap
    }
}

