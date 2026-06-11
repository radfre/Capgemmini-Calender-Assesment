public class Month {
    private Day[] days;

    public Month(){
        days = new Day[30]; 
        for (Day day : days) {
            day = new Day(); 
        }
    }

    public Day getDay(int dayNumber){
        if (dayNumber >= 0 && dayNumber <= days.length-1) {
            return days[dayNumber]; // return the requested day (adjusting for 0-based index)
        }
        return null; // return null if the day number is out of range
    }
}
