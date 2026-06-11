public class Test {
    public static void test1(){
        Month month = new Month();
        
        month.getDay(0).addEvent(new Event(270, 60));
        System.out.println(month.getDay(0).nextAvailableTimeSlot(240, 30).getStartTime()); // should print 240
    }
}
