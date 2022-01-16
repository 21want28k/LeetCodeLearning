package com.company.xx.utils;

public class MyStringUtils {
    /**
     * 把字符串的[] 改为{}
     *
     * @param s
     * @return
     */
    public static String replaceBracketsToBraces(String s) {
        return s.replaceAll("\\[", "{").replaceAll("]", "}");
    }


    public static void main(String[] args) {
        String s = "[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]";
        System.out.println(replaceBracketsToBraces(s));
    }
}