package JE2.DateTime;

import JE2.enums.Day;

import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateTimeExercise {
    public static void main(String[] args) {

        // TODO: Print current date and time
        // LocalDate represents a date in ISO format (yyyy-MM-dd) without time. We can use it to store dates like birthdays and paydays.
        // LocalTime represents time without a date.
        // LocalDateTime is used to represent a combination of date and time.
        LocalDate currentDate = LocalDate.now();
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current Date: "+currentDate);
        System.out.println("Current Date and Time: "+currentDateTime);
        System.out.println("Current Time: "+currentTime);

        //To remove the nanoseconds can Format
        DateTimeFormatter clock = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("Current Time Without NanoSeconds: "+currentTime.format(clock));

        // All the above use the system default time zone. So if working with applications that are in different time zones you would want to do it the below way

        // When doing current values, always good to use zones
        ZoneId london = ZoneId.of("Europe/London");
        ZonedDateTime nowLon = ZonedDateTime.now(london);
        System.out.println("Current time in the UK: "+nowLon);


        // TODO: Parse "2025-01-01" into LocalDate
        // You parse dates so that you can manipulate it and safely do Date maths
        LocalDate parsedDate = LocalDate.parse("2025-01-01");
        System.out.println("Parsed Date: "+parsedDate);


        // TODO: Add 30 days and print the new date
        LocalDate datePlus30 = LocalDate.parse("2025-01-02").plusDays(30);
        System.out.println("Date plus 30 days: "+ datePlus30);

        //  Another way to do the above
        LocalDate start = LocalDate.parse("2030-07-14");
        LocalDate in30  = start.plusDays(30);


        // TODO: Format date as "Wednesday, Jan 1 2025"
        // not sure how I would do this
        // Ai Helped on this one
        DateTimeFormatter niceDate = DateTimeFormatter.ofPattern("EEEE, MMM d uuuu");
        // You can add a .withLocale(Locale.UK) at the end of the above so like DateTimeFormatter.ofPattern("EEEE, MMM d uuuu").withLocale(Locale.UK) to make UK
        LocalDate sample = LocalDate.of(2025, 1, 1);
        String pretty = sample.format(niceDate);
        System.out.println("Pretty date: "+ pretty);

        // With Time
        DateTimeFormatter niceDateTimeWithLocale = DateTimeFormatter.ofPattern("EEEE, MMM d uuuu 'at' h:mm a").withLocale(Locale.UK);
        DateTimeFormatter niceDateTimeWithoutLocale = DateTimeFormatter.ofPattern("EEEE, MMM d uuuu 'at' h:mm a");
        LocalDateTime sample1 = LocalDateTime.of(2030, 7, 14, 18, 45);
        String withTimeAndUKLocale = sample1.format(niceDateTimeWithLocale);
        String withTimeAndNoLocale = sample1.format(niceDateTimeWithoutLocale);
        System.out.println("With Time and UK Locale: "+ withTimeAndUKLocale);
        System.out.println("With Time and NO Locale: "+ withTimeAndNoLocale);
        // No difference in output as my default Locale is already in en_GB


        // TODO: Calculate duration between two LocalDateTime values
        LocalDateTime initialDate = LocalDateTime.parse("2025-01-01T10:07:41.880194");
        LocalDateTime finalDate = LocalDateTime.now();
        long difference = ChronoUnit.DAYS.between(initialDate, finalDate);
        System.out.println("Difference between Date 1: "+initialDate+" and Date 2: "+finalDate+" = "+difference);

    }
}
