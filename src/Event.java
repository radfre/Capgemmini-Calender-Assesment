public class Event {
    private int startTime;
    private int duration;
    private String title;
    private String description;
    // time is represented in minutes from the start of the day (e.g., 0 for 12:00 AM, 60 for 1:00 AM, etc.)

    public Event(int startTime, int duration){
        this.startTime = startTime;
        this.duration = duration;
        this.title = ""; // default title
        this.description = ""; // default description
    }
    
    public Event(int startTime, int duration, String title){
        this.startTime = startTime;
        this.duration = duration;
        this.title = title;
        this.description = ""; // default description
    }
    public Event(int startTime, int duration, String title, String description){
        this.startTime = startTime;
        this.duration = duration;
        this.title = title;
        this.description = description;
    }

    public boolean overlapsWith(Event otherEvent){
        if (this.getStartTime() < otherEvent.getEndTime() && this.getEndTime() > otherEvent.getStartTime()) {
            return true; // events overlap
        }
        return false; // events do not overlap
    }

    public int getStartTime(){
        return startTime;
    }
    
    public int getDuration(){
        return duration;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public int getEndTime(){
        int endTime = startTime + duration; // calculate end time based on start time and duration
        return endTime; // return the calculated end time
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}

