public class Month {
    private Day[] days;

    public Month(){
        days = new Day[30]; 
        for ( int i = 0 ; i < days.length; i++) {
            days[i] = new Day(); 
        }
    }
    public Month(int numberOfDays){
        days = new Day[numberOfDays]; 
        for ( int i = 0 ; i < days.length; i++) {
            days[i] = new Day(); 
        }
    }

    public Day getDay(int dayNumber){
        if (dayNumber >= 0 && dayNumber <= days.length-1) {
            return days[dayNumber]; // return the requested day (adjusting for 0-based index)
        } else {
            return null; // return null if the day number is out of range
        }
    }
    public Day[] getDays(){
        return days; // return the array of days in the month
    }
}
