package com.example.isproticketpurchaseuattests;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DifferentDateTime {
    public static String returnFuture(int plusDays) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrow;
        DayOfWeek day = now.getDayOfWeek();
        String dayString = day.toString();

        if(dayString == "FRIDAY" || dayString == "SATURDAY"){
            System.out.println(dayString);
            tomorrow = now.plusDays(plusDays+2);
        }else{
            tomorrow = now.plusDays(plusDays);
        }

        String tomorrowFormatted = dtf.format(tomorrow);
        return tomorrowFormatted;


    }
}
