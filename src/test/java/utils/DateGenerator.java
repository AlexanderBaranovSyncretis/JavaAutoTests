package utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;

public class DateGenerator {

    public static String getCurrentYear() {
        return getCurrentDate("yyyy");
    }

    public static String getCurrentMonth() {
        return getCurrentDate("MM");
    }

    public static String getCurrentDay() {
        return getCurrentDate("dd");
    }

    public static String getCurrentDate(String pattern) {
        return new SimpleDateFormat(pattern).format(new Date());
    }

    public static ArrayList<String> getListOfDatesForMonth(Object year, Object month) {
        ArrayList<String> daysList = new ArrayList<>();
        int intYear = Integer.parseInt(String.valueOf(year));
        int intMonth = Integer.parseInt(String.valueOf(month));

        if (intMonth - 12 > 0) {
            int count = 0;

            while (intMonth - 12 > 0) {
                intMonth -= 12;
                count++;
            }

            intYear += count;
        }

        YearMonth ym = YearMonth.of(intYear, intMonth);

        for (int i = 1; i <= ym.lengthOfMonth(); i++) {
            LocalDate localDate = ym.atDay(i);
            daysList.add(String.valueOf(localDate));
        }

        return daysList;
    }
}
