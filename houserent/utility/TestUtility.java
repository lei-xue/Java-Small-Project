package com.sherry.houserent.utility;

public class TestUtility {
    public static void main(String[] args) {
        String s = Utility.readString(3);
        System.out.println("s=" + s);
        System.out.println("Please input your string!");
        String s2 = Utility.readString(10,"lei");
        System.out.println("s2=" + s2);
    }
}
