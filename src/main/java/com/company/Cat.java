package com.company;

import java.util.HashMap;
import java.util.Map;

public class Cat implements Animal<Cat> {
    @Override
    public void eat(Cat s) {
        System.out.println("cat eat " + s);
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 3);
        System.out.println(map);
    }
}
