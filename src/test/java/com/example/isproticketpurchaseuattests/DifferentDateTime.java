package com.example.isproticketpurchaseuattests;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DifferentDateTime {
    public static String returnFuture(int plusDays) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime desiredDay = now.plusDays(plusDays);
        LocalDateTime tomorrow;
        DayOfWeek day = desiredDay.getDayOfWeek();
        String dayString = day.toString();

        if(dayString == "SUNDAY" || dayString == "SATURDAY"){
            System.out.println(dayString);
            tomorrow = now.plusDays(plusDays+2);
        }else{
            System.out.println(dayString);
            tomorrow = now.plusDays(plusDays);
        }

        String tomorrowFormatted = dtf.format(tomorrow);
        return tomorrowFormatted;


    }
}
