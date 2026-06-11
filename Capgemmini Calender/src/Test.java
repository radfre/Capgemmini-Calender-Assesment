public class Test {
    public static void test1(){
        Month month = new Month();
        Day day = new Day();
        day.addEvent(new Event(270, 60));
        System.out.println(day.nextAvailableTimeSlot(240, 30).getStartTime()); // should print 240
    }
}
