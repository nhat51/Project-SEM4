package com.example.englishappbackend.util;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class HandleTime {

    public static void main(String[] args) {
        HandleTime handleTime = new HandleTime();
        Date date = new Date();
        long fromAndroid = handleTime.convertStringToLong("14:55");
        System.out.println("Time from android: " + fromAndroid);
        long serverConvert = handleTime.calculateTimeToLong(date.getHours(), date.getMinutes());
        System.out.println("Time of server: " + serverConvert);


        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(date);
        System.out.println("=========Date================");
        System.out.println("Calendar hour:" + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("android hour:" + fromAndroid);

    }

    public long convertStringToLong(String s) {
        String[] hourMin = s.split(":");
        int hour = Integer.parseInt(hourMin[0]);
        int mins = Integer.parseInt(hourMin[1]);
        int hoursInMins = hour * 60;
        return hoursInMins + mins;
    }

    /*
    cộng giờ với phút lại với nhau
    */
    public long calculateTimeToLong(int hour, int minute) {
        /*Date date = new Date();
        int hour = date.getHours();
        int mins = date.getMinutes();*/
        int hoursInMins = hour * 60;
        return hoursInMins + minute;
    }
}
