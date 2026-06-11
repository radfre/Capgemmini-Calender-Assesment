# Calender Assesment

### CLI Calendar Management Application in Java

A Command Line Interface (CLI) Calendar Management Application developed in Java that allows users to create, manage, and organize daily events. The application helps users schedule activities, view events, find available time slots, and avoid scheduling conflicts.

## Key Features
* View all days in the calendar and the number of events scheduled for each day.
* Display all events for a selected day.
* View remaining events after a specified time.
* Add new events with conflict detection.
* Remove existing events.
* Modify event details including:
* Start time
* Duration
* Title
* Description
* Find the next available time slot for a new event.
* Input validation to prevent invalid user entries.

## Technologies Used
* Java
* Object-Oriented Programming (OOP)
* Command Line Interface (CLI)
* Java Collections and Data Structures

## Class Descritpions

### Month
Represents A month Containg Multiple Das and managening acess to each day.

### Day
Stores manages and acess Events for a single day, Including Event Conflict Checks.


### Event
Represents an Event with,
* Start Time
* Duration
* End Time
* Title
* Description
* and quick Event overlap checking

### Test
A Set of test cases and scenarios to validate functionality

### CommandInterface
Handles user interaction, Menu Navigation, input validation, and applicaion workflow

## How To Run

### Compile
` javac .\src\*.java`

### run
` java .\src\CommandInterface.java `

## Menu Options
1. List all dates
2. List all Events for a Date
3. List all Remaining Events for a Date
4. Add an Event
5. Remove an Event
6. Modify an Event
7. Next Available Timeslot for a Day


## Conflict Detection
The application prevents overlapping events from being scheduled on the same day. If a conflict is detected, the user is prompted to enter a different time.

## Future Imporvents
* Save and Load Calender
* Support Real Calender Dates and Years
* Add Recuring Events
* Add Event Categories
* Exports schedules to CSV or JSON
* Improve Time and Display using HH:MM Formating
* Utile RealTime such as the Java Date and Time API

## Learnign Outcomes
This project demonstrates:

* Object-Oriented Programming principles
* Data management using custom classes
* User input handling and validation
* Event scheduling algorithms
* Conflict detection and resolution
* CLI application development in Java


## Testing
### Test 1
### Listing all events for the day and List all remaining events for the day
code:
```
System.out.println("== Test 1 ==");
        Month month = new Month();
        System.out.println("adding events to day 0");
        month.getDay(0).addEvent(new Event(270, 60));
        month.getDay(0).addEvent(new Event(360, 60));
        month.getDay(0).addEvent(new Event(480, 60));
        month.getDay(0).addEvent(new Event(1080, 60));

        System.out.println("adding events to day 1");
        month.getDay(1).addEvent(new Event(330, 30));
        month.getDay(1).addEvent(new Event(420, 90));
        month.getDay(1).addEvent(new Event(540, 60));
        month.getDay(1).addEvent(new Event(1300, 60));
        System.out.println();

        System.out.println("Listing all events on day 0");
        for (Event event : month.getDay(0).listAllEvents()) {
            System.out.println("Day 0 Event: " + event.getStartTime() + " - " + event.getEndTime() + " "
                    + event.getTitle() + " " + event.getDescription());
        }
        System.out.println();

        System.out.println("Listing all events on day 1");
        for (Event event : month.getDay(1).listAllEvents()) {
            System.out.println("Day 1 Event: " + event.getStartTime() + " - " + event.getEndTime() + " "
                    + event.getTitle() + " " + event.getDescription());
        }
        System.out.println();

        System.out.println("Listing all remaining events on day 0 starting from 400");
        for (Event event : month.getDay(0).listAllRemainingEvents(400)) {
            System.out.println("Day 0 Event: " + event.getStartTime() + " - " + event.getEndTime() + " "
                    + event.getTitle() + " " + event.getDescription());
        }
        System.out.println();

        System.out.println("Listing all remaining events on day 1 starting from 800");
        for (Event event : month.getDay(1).listAllRemainingEvents(800)) {
            System.out.println("Day 1 Event: " + event.getStartTime() + " - " + event.getEndTime() + " "
                    + event.getTitle() + " " + event.getDescription());
        }
```
expected result: 
Verifies that all events are displayed in chronological order and that filtering remaining events after a specified time returns only future events.
output:
```
== Test 1 ==
adding events to day 0
adding events to day 1

Listing all events on day 0
Day 0 Event: 0 - 0 Start of day 
Day 0 Event: 270 - 330  
Day 0 Event: 360 - 420  
Day 0 Event: 480 - 540  
Day 0 Event: 1080 - 1140  
Day 0 Event: 1440 - 1440 End of day 

Listing all events on day 1
Day 1 Event: 0 - 0 Start of day 
Day 1 Event: 330 - 360  
Day 1 Event: 420 - 510  
Day 1 Event: 540 - 600  
Day 1 Event: 1300 - 1360  
Day 1 Event: 1440 - 1440 End of day 

Listing all remaining events on day 0 starting from 400
Day 0 Event: 480 - 540  
Day 0 Event: 1080 - 1140  
Day 0 Event: 1440 - 1440 End of day 

Listing all remaining events on day 1 starting from 800
Day 1 Event: 1300 - 1360  
Day 1 Event: 1440 - 1440 End of day 
```
### Test2
### Removing Events and Maintaining Event Order
code:
```
    public static void test2() { // This test is to check the remove event functionality and that the events are listed in order of start time
        System.out.println("== Test 2 ==");
        Month month = new Month();
        System.out.println("adding events to day 0");
        month.getDay(0).addEvent(new Event(270, 60));
        month.getDay(0).addEvent(new Event(360, 60));
        month.getDay(0).addEvent(new Event(480, 60));
        month.getDay(0).addEvent(new Event(1080, 60));

        System.out.println("Listing all events on day 0");
        for (Event event : month.getDay(0).listAllEvents()) {
            System.out.println("Day 0 Event: " + event.getStartTime() + " - " + event.getEndTime() + " "
                    + event.getTitle() + " " + event.getDescription());
        }

        System.out.println();
        System.out.println("Removing event at 360 from day 0");
        System.out.println();
        month.getDay(0).removeEvent(360);
         System.out.println("Listing all events on day 0");
        for (Event event : month.getDay(0).listAllEvents()) {
            System.out.println("Day 0 Event: " + event.getStartTime() + " - " + event.getEndTime() + " "
                    + event.getTitle() + " " + event.getDescription());
        }
    }
```
expected result:
Verifies that an event can be removed successfully and that the remaining events stay in chronological order.
output:
```
== Test 2 ==
adding events to day 0
Listing all events on day 0
Day 0 Event: 0 - 0 Start of day 
Day 0 Event: 270 - 330  
Day 0 Event: 360 - 420  
Day 0 Event: 480 - 540  
Day 0 Event: 1080 - 1140  
Day 0 Event: 1440 - 1440 End of day 

Removing event at 360 from day 0

Listing all events on day 0
Day 0 Event: 0 - 0 Start of day 
Day 0 Event: 270 - 330  
Day 0 Event: 480 - 540  
Day 0 Event: 1080 - 1140  
Day 0 Event: 1440 - 1440 End of day 
```
### Test 3
### Event Conflict Detection During Addition
code:
```
 public static void test3() { // This test is to check conflicts when adding events
        System.out.println("== Test 3 ==");
        Month month = new Month();
        System.out.println("adding events to day 0");
        month.getDay(0).addEvent(new Event(270, 60));
        month.getDay(0).addEvent(new Event(360, 60));
        month.getDay(0).addEvent(new Event(480, 60));
        month.getDay(0).addEvent(new Event(1080, 60));

        System.out.println("Listing all events on day 0");
        for (Event event : month.getDay(0).listAllEvents()) {
            System.out.println("Day 0 Event: " + event.getStartTime() + " - " + event.getEndTime() + " "
                    + event.getTitle() + " " + event.getDescription());
        }
        System.out.println();
        System.out.println("Adding an event that overlaps with an existing event on day 0 at 300 for 80 minutes");
        System.out.println("Adding an event that overlaps with an existing event on day 0 at 480 for 60 minutes");
        System.out.println("Adding an event that overlaps with an existing event on day 0 at 1140 for 60 minutes");
        System.out.println("two of the events should not be added because they overlap with existing events and one should be added because it does not overlap with any existing events");
        System.out.println();

        month.getDay(0).addEvent(new Event(300, 80, "Cleaning"));
        month.getDay(0).addEvent(new Event(480, 60, "Soccer"));
        month.getDay(0).addEvent(new Event(1140, 60, "Dinner"));

        System.out.println("Listing all events on day 0");
        for (Event event : month.getDay(0).listAllEvents()) {
            System.out.println("Day 0 Event: " + event.getStartTime() + " - " + event.getEndTime() + " "
                    + event.getTitle() + " " + event.getDescription());
        }
    }
```
expected result:
Verifies that overlapping events are rejected while non-overlapping events are added successfully.
output:
```
== Test 3 ==
adding events to day 0
Listing all events on day 0
Day 0 Event: 0 - 0 Start of day 
Day 0 Event: 270 - 330  
Day 0 Event: 360 - 420  
Day 0 Event: 480 - 540  
Day 0 Event: 1080 - 1140  
Day 0 Event: 1440 - 1440 End of day 

Adding an event that overlaps with an existing event on day 0 at 300 for 80 minutes
Adding an event that overlaps with an existing event on day 0 at 480 for 60 minutes
Adding an event that overlaps with an existing event on day 0 at 1140 for 60 minutes
two of the events should not be added because they overlap with existing events and one should be added because it does not overlap with any existing events

Listing all events on day 0
Day 0 Event: 0 - 0 Start of day 
Day 0 Event: 270 - 330  
Day 0 Event: 360 - 420  
Day 0 Event: 480 - 540  
Day 0 Event: 1080 - 1140  
Day 0 Event: 1140 - 1200 Dinner 
Day 0 Event: 1440 - 1440 End of day 
```
### Test 4
### Modifying Event Titles and Descriptions
code:
```
public static void test4() { // This test it to modify the events to have a title and description 
        System.out.println("== Test 4 ==");
        Month month = new Month();
        System.out.println("adding events to day 0");
        month.getDay(0).addEvent(new Event(270, 60));
        month.getDay(0).addEvent(new Event(360, 60));
        month.getDay(0).addEvent(new Event(480, 60));
        month.getDay(0).addEvent(new Event(1080, 60));

        System.out.println("Listing all events on day 0");
        for (Event event : month.getDay(0).listAllEvents()) {
            System.out.println("Day 0 Event: " + event.getStartTime() + " - " + event.getEndTime() + " "
                    + event.getTitle() + " " + event.getDescription());
        }

        System.out.println();
        System.out.println("modifying event at 360 from day 0 to have a title and description");
        month.getDay(0).getEvent(360).setDescription("DevOps Standup");
        month.getDay(0).getEvent(360).setTitle("Team Meeting");

        System.out.println("modifying event at 480 from day 0 to have a title and description");
        month.getDay(0).getEvent(480).setDescription("Eggs and bacon");
        month.getDay(0).getEvent(480).setTitle("Breakfast");

        System.out.println();
        System.out.println("Listing all events on day 0");
        for (Event event : month.getDay(0).listAllEvents()) {
            System.out.println("Day 0 Event: " + event.getStartTime() + " - " + event.getEndTime() + " "
                    + event.getTitle() + " " + event.getDescription());
        }

    }
```
expected result: Verifies that an existing event's title and description can be updated and that the changes are reflected when listing events.
output:
```
== Test 4 ==
adding events to day 0
Listing all events on day 0
Day 0 Event: 0 - 0 Start of day 
Day 0 Event: 270 - 330  
Day 0 Event: 360 - 420  
Day 0 Event: 480 - 540  
Day 0 Event: 1080 - 1140  
Day 0 Event: 1440 - 1440 End of day 

modifying event at 360 from day 0 to have a title and description
modifying event at 480 from day 0 to have a title and description

Listing all events on day 0
Day 0 Event: 0 - 0 Start of day 
Day 0 Event: 270 - 330  
Day 0 Event: 360 - 420 Team Meeting DevOps Standup
Day 0 Event: 480 - 540 Breakfast Eggs and bacon
Day 0 Event: 1080 - 1140  
Day 0 Event: 1440 - 1440 End of day
```
