package com.techriders.wirehouseservice.helpers;

public class MyHelper {
    public static long getRandomInt(){
        long leftLimit = 100000L;
        long rightLimit = 1000000000000L;
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }
}
