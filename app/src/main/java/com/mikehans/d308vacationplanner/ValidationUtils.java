package com.mikehans.d308vacationplanner;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ValidationUtils {

    public static boolean isValidDate(String date) {
        return date != null && date.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    public static boolean isDateRangeValid(String start, String end) {
        try {
            LocalDate startDate = LocalDate.parse(start);
            LocalDate endDate = LocalDate.parse(end);
            return endDate.isAfter(startDate);
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}

