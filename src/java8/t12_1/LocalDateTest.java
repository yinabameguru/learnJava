package java8.t12_1;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import org.junit.Test;

public class LocalDateTest {

    @Test
    public void localDateTest() {

//        Boolean b = null;
//        if (b) {
//            System.out.println("aaa");
//        }
//        LocalDate now = LocalDate.now();
//        System.out.println(now);
//        System.out.println(now.get(ChronoField.DAY_OF_YEAR));
//        LocalDate date = LocalDate.parse("1111-11-11");
//        System.out.println(date);
//        LocalTime time = LocalTime.parse("11:11:11");
//        System.out.println(time);
//        LocalDateTime dateTime = LocalDateTime.now();
//        System.out.println(dateTime);
//        LocalDateTime dateTime1 = LocalDateTime.of(date, time);
//        System.out.println(dateTime1);
//        Instant instant = Instant.ofEpochSecond(0L);
//        System.out.println(instant);
//        Instant instant1 = Instant.ofEpochSecond(1L, 1L);
//        System.out.println(instant1);
////        System.out.println(instant1.get(ChronoField.DAY_OF_MONTH));
//        Duration between = Duration.between(instant, instant1);
//        System.out.println(between);
//        Duration between1 = Duration.between(instant1, instant);
//        System.out.println(between1);
////        Duration between2 = Duration.between(instant, LocalDateTime.now());
////        System.out.println(between2);
//        Duration between2 = Duration.between(LocalDateTime.now(), LocalDateTime.now());
//        System.out.println(between2);
//        Period between3 = Period.between(LocalDate.of(2_000, 1, 1), LocalDate.now());
//        System.out.println(between3);
        LocalDateTime start = LocalDateTime.now().withDayOfMonth(1).withHour(0)
            .withMinute(0).withSecond(0).withNano(0);
        System.out.println(start);
        LocalDateTime end = start.plusMonths(1);
        System.out.println(end);

//        TemporalAdjuster temporalAdjuster = TemporalAdjusters.dayOfWeekInMonth(1, DayOfWeek.MONDAY);
//        System.out.println(temporalAdjuster.adjustInto());
    }

}
