package demo;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;
import java.util.stream.Stream;

/**
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
public class Main {

    public static void main(String[] args) {        
                
        System.out.println("\n==== Play with resource files");
        
        Person p1 = new Person( "Richard", LocalDate.of( 1985, 1, 1 ), new BigDecimal( 250000 ), Nationality.DUTCH);
        System.out.println(p1.introduceYourself());
        
        Person p2 = new Person("Linda", LocalDate.of(1985, 1, 1), new BigDecimal(500000), Nationality.GERMAN);
        System.out.println(p2.introduceYourself());
        
        Person p3 = new Person("Donald", LocalDate.of(1946, 6, 14), new BigDecimal(100000), Nationality.AMERICAN);
        System.out.println(p3.introduceYourself());

    }

}
