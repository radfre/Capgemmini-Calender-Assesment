# Calender Assesment

### CLI Calendar Management Application in Java

A Command Line Interface (CLI) Calendar Management Application developed in Java that allows users to create, manage, and organize daily events. The application helps users schedule activities, view events, find available time slots, and avoid scheduling conflicts.

## Approach and desing
The goal of this project is to create a command-line calendar application that allows users to manage daily events while preventing scheduling conflicts.


The application was divided into separate classes, each with a specific responsibility. The project was approached using object-oriented design, primarily through the Day class. Each Day acts as a structure that encapsulates events together for ease of access. The Day class handles most conflict resolution by reading through its collection of events and checking for overlaps whenever an event is added or modified.

The Month class serves as a container for all Day objects and provides a way to access and manage individual days. The Event class represents a single calendar event and stores information such as start time, duration, title, and description. Event objects also provide functionality for determining whether two events overlap.

User interaction is handled separately through the CommandInterface class. This class manages menu navigation, input validation, and communication between the user and the calendar data structures. Separating the user interface from the calendar logic keeps the code organized and easier to maintain.

Events are stored in chronological order based on their start time. This design simplifies event listing, conflict detection, and finding available time slots. Special start-of-day and end-of-day events are used as boundary markers, making it easier to identify gaps in the schedule when searching for free time.

This design follows object-oriented programming principles by separating responsibilities between classes, encapsulating data, and creating a structure that can be easily extended with future features such as recurring events, file saving/loading, or support for real calendar dates.

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

## How To Run

### Compile
` javac .\src\*.java`

### run
` java .\src\CommandInterface.java `



## Conflict Detection
The application prevents overlapping events from being scheduled on the same day. If a conflict is detected, the user is prompted to enter a different time.

## Future Imporvents
* Save and Load calendar
* Support Real Calender Dates and Years
* Add Recuring Events
* Add Event Categories
* Exports schedules to CSV or JSON
* Improve Time and Display using HH:MM Formating
* Utile RealTime such as the Java Date and Time API

## Learning Outcomes
This project demonstrates:

* Object-Oriented Programming principles
* Data management using custom classes
* User input handling and validation
* Event scheduling algorithms
* Conflict detection and resolution
* CLI application development in Java

## Testing

### Test 1 - Event Listing
Purpose: Verify chronological ordering and filtering.

Result: PASS

### Test 2 - Event Removal
Purpose: Verify events are removed and ordering remains intact.

Result: PASS

### Test 3 - Conflict Detection
Purpose: Verify overlapping events are rejected.

Result: PASS

### Test 4 - Event Modification
Purpose: Verify titles and descriptions can be updated.

Result: PASS

To run the tests, execute the Test.java file.