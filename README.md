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
