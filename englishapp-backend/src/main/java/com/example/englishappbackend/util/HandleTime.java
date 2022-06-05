package com.example.englishappbackend.util;


import java.util.Date;

public class HandleTime {

    public static void main(String[] args) {
        HandleTime handleTime = new HandleTime();
        long fromAndroid = handleTime.convertStringToLong("20:54");
        System.out.println("Time from android: " + fromAndroid);
        long serverConvert = handleTime.convertLongToTime();
        System.out.println("Time of server: " + serverConvert);

    }

    public long convertStringToLong(String s) {
        String[] hourMin = s.split(":");
        int hour = Integer.parseInt(hourMin[0]);
        int mins = Integer.parseInt(hourMin[1]);
        int hoursInMins = hour * 60;
        return hoursInMins + mins;
    }

    public long convertLongToTime() {
        Date date = new Date();
        int hour = date.getHours();
        int mins = date.getMinutes();
        int hoursInMins = hour * 60;
        return hoursInMins + mins;
    }
}
