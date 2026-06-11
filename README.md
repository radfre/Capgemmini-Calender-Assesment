# Calender Assesment

###CLI Calendar Management Application in Java

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

