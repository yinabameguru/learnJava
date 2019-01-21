package java8.t12_1;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.chrono.ChronoPeriod;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

public class LocalDateTest {

    @Test
    public void localDateTest() {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println(now.get(ChronoField.DAY_OF_YEAR));
        LocalDate date = LocalDate.parse("1111-11-11");
        System.out.println(date);
        LocalTime time = LocalTime.parse("11:11:11");
        System.out.println(time);
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        LocalDateTime dateTime1 = LocalDateTime.of(date, time);
        System.out.println(dateTime1);
        Instant instant = Instant.ofEpochSecond(0L);
        System.out.println(instant);
        Instant instant1 = Instant.ofEpochSecond(1L, 1L);
        System.out.println(instant1);
//        System.out.println(instant1.get(ChronoField.DAY_OF_MONTH));
        Duration between = Duration.between(instant, instant1);
        System.out.println(between);
        Duration between1 = Duration.between(instant1, instant);
        System.out.println(between1);
//        Duration between2 = Duration.between(instant, LocalDateTime.now());
//        System.out.println(between2);
        Duration between2 = Duration.between(LocalDateTime.now(), LocalDateTime.now());
        System.out.println(between2);
        Period between3 = Period.between(LocalDate.of(2_000, 1, 1), LocalDate.now());
        System.out.println(between3);
        LocalDateTime start = LocalDateTime.now().withDayOfMonth(1).withHour(0)
            .withMinute(0).withSecond(0).withNano(0);
        System.out.println(start);
        LocalDateTime end = start.plusMonths(1);
        System.out.println(end);
        long l = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(l);
        System.out.println(new Date().getTime());
        LocalDateTime localDateTime = LocalDate.now().atTime(LocalTime.now());
        System.out.println(localDateTime);
        System.out.println(new Date());
        Instant instant2 = Instant.ofEpochSecond(1);
        System.out.println(instant2);
        Instant instant3 = Instant.now();
        System.out.println(instant3);
        long l1 = instant3.toEpochMilli();
        System.out.println(l1);
        Duration from = Duration.from(ChronoUnit.CENTURIES.getDuration());
        System.out.println(from);
        LocalDateTime localDateTime1 = LocalDateTime.now().with(ChronoField.HOUR_OF_DAY, 0);
        System.out.println(localDateTime1 + ",now:" + LocalDateTime.now());
        LocalDateTime localDateTime2 = LocalDateTime.now().with(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH, 1);
        System.out.println(localDateTime2 + ",now:" + LocalDateTime.now());
        LocalDateTime localDateTime3 = LocalDateTime.now().with(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR, 1);
        System.out.println(localDateTime3 + ",now:" + LocalDateTime.now());
        LocalDateTime localDateTime4 = LocalDateTime.now().with(ChronoField.ALIGNED_WEEK_OF_MONTH, 1);
        System.out.println(localDateTime4 + ",now:" + LocalDateTime.now());
        LocalDateTime localDateTime5 = LocalDateTime.now().with(ChronoField.ALIGNED_WEEK_OF_YEAR, 1);
        System.out.println(localDateTime5 + ",now:" + LocalDateTime.now());
        LocalDateTime localDateTime6 = LocalDateTime.now().with(ChronoField.DAY_OF_YEAR, 1);
        System.out.println(localDateTime6 + ",now:" + LocalDateTime.now());
        LocalDateTime localDateTime7 = LocalDateTime.now().with(ChronoField.AMPM_OF_DAY, 0);
        System.out.println(localDateTime7 + ",now:" + LocalDateTime.now());
        LocalDateTime localDateTime8 = LocalDateTime.now().with(ChronoField.CLOCK_HOUR_OF_DAY, 24);
        System.out.println(localDateTime8 + ",now:" + LocalDateTime.now());
        LocalDateTime localDateTime9 = LocalDateTime.now().with(ChronoField.CLOCK_HOUR_OF_AMPM, 1);
        System.out.println(localDateTime9 + ",now:" + LocalDateTime.now());
        LocalDateTime localDateTime10 = LocalDateTime.now().with(ChronoField.DAY_OF_WEEK, 1);
        System.out.println(localDateTime10 + ",now:" + LocalDateTime.now());
        LocalDateTime localDateTime11 = LocalDateTime.now().with(ChronoField.EPOCH_DAY, 1);
        System.out.println(localDateTime11 + ",now:" + LocalDateTime.now());
        LocalDateTime localDateTime12 = LocalDateTime.now().with(ChronoField.ERA, 1);
        System.out.println(localDateTime12 + ",now:" + LocalDateTime.now());
        LocalDateTime localDateTime13 = LocalDateTime.now().with(ChronoField.HOUR_OF_AMPM, 0);
        System.out.println(localDateTime13 + ",now:" + LocalDateTime.now());
//        LocalDateTime localDateTime14 = LocalDateTime.now().with(ChronoField.INSTANT_SECONDS, 1);
//        System.out.println(localDateTime14 + ",now:" + LocalDateTime.now());
        //一天开始的LocalDateTime 2019-01-18T00:00，精确到微妙
        LocalDateTime localDateTime14 = LocalDateTime.now().with(ChronoField.MICRO_OF_DAY, 1);
        System.out.println(localDateTime14 + ",now:" + LocalDateTime.now());
        //this精确到秒2019-01-18T17:30:36
        LocalDateTime localDateTime15 = LocalDateTime.now().with(ChronoField.MICRO_OF_SECOND, 0);
        System.out.println(localDateTime15 + ",now:" + LocalDateTime.now());
        //一天开始的LocalDateTime 2019-01-18T00:00，精确到毫秒
        LocalDateTime localDateTime16 = LocalDateTime.now().with(ChronoField.MILLI_OF_DAY, 1);
        System.out.println(localDateTime16 + ",now:" + LocalDateTime.now());
        //一天开始的LocalDateTime 2019-01-18T00:00，精确到纳秒
        LocalDateTime localDateTime17 = LocalDateTime.now().with(ChronoField.NANO_OF_DAY, 1);
        System.out.println(localDateTime17 + ",now:" + LocalDateTime.now());
//        LocalDateTime localDateTime18 = LocalDateTime.now().with(ChronoField.OFFSET_SECONDS, 1);
//        System.out.println(localDateTime18 + ",now:" + LocalDateTime.now());
        LocalDateTime localDateTime18 = LocalDateTime.now().with(ChronoField.PROLEPTIC_MONTH, 1);
        System.out.println(localDateTime18 + ",now:" + LocalDateTime.now());
        LocalDateTime localDateTime19 = LocalDateTime.now().with(ChronoField.MINUTE_OF_DAY, 1);
        System.out.println(localDateTime19 + ",now:" + LocalDateTime.now());
        LocalDateTime localDateTime20 = LocalDateTime.now().with(ChronoField.YEAR, 1);
        System.out.println(localDateTime20 + ",now:" + LocalDateTime.now());
        //ChronoUnit 日期单位enum
        LocalDateTime localDateTime21 = LocalDateTime.now().plus(1, ChronoUnit.DAYS);
        System.out.println(localDateTime21 + ",now:" + LocalDateTime.now());
        LocalDateTime localDateTime22 = LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(localDateTime22 + ",now:" + LocalDateTime.now());
        LocalDateTime localDateTime23 = LocalDateTime.now()
            .with(TemporalAdjusters.dayOfWeekInMonth(1, DayOfWeek.MONDAY));
        System.out.println(localDateTime23 + ",now:" + LocalDateTime.now());
        LocalDateTime localDateTime24 = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(localDateTime24 + ",now:" + LocalDateTime.now());
        LocalDateTime localDateTime25 = LocalDateTime.now().with(temporal -> temporal.plus(Period.ofMonths(1)));
        System.out.println(localDateTime25 + ",now:" + LocalDateTime.now());
        String format = LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(format);
        String format1 = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(format1);
        String format2 = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
        System.out.println(format2);
        String format3 = LocalDateTime.now().format(DateTimeFormatter.ISO_WEEK_DATE);
        System.out.println(format3);

//        LocalDateTime localDateTime12 = LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0));
//        System.out.println(localDateTime12 + ",now:" + LocalDateTime.now());

//        Boolean b = null;
//        if (b) {
//            System.out.println("aaa");
//        }
//        TemporalAdjuster temporalAdjuster = TemporalAdjusters.dayOfWeekInMonth(1, DayOfWeek.MONDAY);
//        System.out.println(temporalAdjuster.adjustInto());
    }

}
