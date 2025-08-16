# 🏋️ Java Practice Exercises – Level 2

This repository contains intermediate-level Java exercises designed to practice core concepts like generics, enums, records, concurrency, file I/O, date/time API, JDBC, testing, design patterns, and a final challenge project.

📘 Exercises
--- 

### 1. Generics Exercise

Create a generic container class:

```java
// TODO: Create a generic Box<T> class
public class Box<T> {
    // TODO: private field of type T
    
    // TODO: constructor, getter, setter
    
    // TODO: method to check if box is empty
}


Test:

public class GenericTest {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>("Hello");
        Box<Integer> intBox = new Box<>(42);
        
        System.out.println("String box: " + stringBox.get());
        System.out.println("Int box: " + intBox.get());
        
        // TODO: Create a generic method that prints any array
        // Example: printArray(new Integer[]{1,2,3});
    }
}
```
--- 
### 2. Enums & Records Exercise
```java
// TODO: Create enum Day with MONDAY..SUNDAY and a method isWeekend()

// TODO: Create a record Point(int x, int y) with a distanceFromOrigin() method


Test:

public class EnumRecordTest {
    public static void main(String[] args) {
        Day today = Day.SATURDAY;
        System.out.println("Is weekend? " + today.isWeekend());
        
        Point p = new Point(3, 4);
        System.out.println("Distance: " + p.distanceFromOrigin());
    }
}
```
--- 
### 3. Concurrency Exercise
```java
public class ConcurrencyExercise {
    // TODO: Create a Runnable task that prints numbers 1–5 with a delay
    
    public static void main(String[] args) throws InterruptedException {
        // TODO: Run two threads with the same task
        
        // TODO: Use ExecutorService with Callable to return a result (e.g. factorial of a number)
        
        // TODO: Use CompletableFuture to run async tasks and combine results
    }
}
```
--- 
### 4. File I/O Exercise
```java
import java.io.*;
import java.nio.file.*;

public class FileExercise {
    public static void main(String[] args) {
        // TODO: Write a list of names to "students.txt"
        
        // TODO: Read the file and print each line
        
        // TODO: Count how many lines are in the file
        
        // TODO: Use NIO Files API to copy the file
    }
}
```
--- 
### 5. Date/Time API Exercise
```java
import java.time.*;
import java.time.format.*;

public class DateTimeExercise {
    public static void main(String[] args) {
        // TODO: Print current date and time
        
        // TODO: Parse "2025-01-01" into LocalDate
        
        // TODO: Add 30 days and print the new date
        
        // TODO: Format date as "Wednesday, Jan 1 2025"
        
        // TODO: Calculate duration between two LocalDateTime values
    }
}
```
--- 
### 6. JDBC Exercise
```java
// TODO: Connect to a database (H2, MySQL, or PostgreSQL)

// TODO: Create a table Students(id, name, grade)

// TODO: Insert some records

// TODO: Query all students and print results

// TODO: Use PreparedStatement to query by grade threshold
```
--- 
### 7. Testing Exercise (JUnit & Mockito)
```java
// TODO: Create Calculator class with add, subtract, multiply, divide

// TODO: Write JUnit tests for Calculator

// TODO: Create UserService that depends on UserRepository

// TODO: Use Mockito to mock UserRepository in tests
```
--- 
### 8. Design Pattern Exercise (Factory + Singleton)
```java
// TODO: Create interface Notification with method send(String message)

// TODO: Implement EmailNotification and SMSNotification

// TODO: Create NotificationFactory that returns correct type

// TODO: Implement Singleton Logger class


Test:

public class PatternTest {
    public static void main(String[] args) {
        Notification n = NotificationFactory.create("EMAIL");
        n.send("Hello from factory!");
        
        Logger logger = Logger.getInstance();
        logger.log("This is a log entry.");
    }
}
```
--- 
### 9. Challenge Project: To-Do List Manager

- Bring it all together in a mini-project:
- Store tasks (id, description, dueDate, completed) in a database.
- Provide CRUD methods: addTask, markCompleted, listTasks, deleteTask.
- Use Optional<Task> for lookups.
- Use Streams to filter tasks (e.g., overdue tasks).
- Implement concurrency: auto-save tasks every X seconds.
- Write JUnit tests for the service layer.
- Use design patterns: Factory for different storage backends (File vs DB).
