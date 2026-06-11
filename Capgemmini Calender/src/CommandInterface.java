import java.util.Scanner;

public class CommandInterface {
    static Scanner scanner;
    static Month month;
    public static void main(String[] args) throws Exception {
        month = new Month(); // create a month with 30 days
        scanner = new Scanner(System.in); // create a scanner for user input
        
        while (true) {
            // Menu
            System.out.println(
            "1. List all dates \n" +
            "2. List all Events for a Date \n" +
            "3. Modify Events for a Date \n" +
            "4. Add/remove an Event \n" +
            "5. next avaible timeslot for a day");
                
            switch(scanner.nextInt()){
                case 1:
                    listAllDates();
                    break;
                case 2:
                    listAllEvents();
                    break;
                case 3:
                    modifyEvent();
                    break;
                case 4:
                    addEvent();
                    break;
                case 5:
                    nextAvaibleEvent();
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    Thread.sleep(1000); // pause for a moment before showing the menu again
            }
             System.out.println();
                
        }
    }
    
    private static void listAllDates(){
        for (int i = 0; i < month.getDays().length; i++){
            System.out.println("Day " + i+ ": " + (month.getDay(i).listAllEvents().size()-2) + " events"); // subtract 2 to account for the default start and end of day events1
        }
        
        System.out.println("enter any key to continue");
        scanner.next(); // wait for user to press Enter
    }
    private static void listAllEvents(){
        

    }
    private static void modifyEvent(){
        
    }
    private static void addEvent(){
        
    }
    private static void nextAvaibleEvent(){
        
    }
}
