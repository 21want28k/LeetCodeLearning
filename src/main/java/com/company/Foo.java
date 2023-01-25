package com.company;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.lang.reflect.Method;
import java.util.HashMap;

public class Foo<T> {
    private String val;
    private T obj;

    public T getObj() {
        return obj;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "val='" + val + '\'' +
                ", obj=" + obj +
                '}';
    }

    public static void main(String[] args) {
        String jsonStr = "{\"obj\":{\"name\":\"Hydra\",\"age\":\"18\"},\"val\":\"str\"}";
        Foo<User> foo = JSONObject.parseObject(jsonStr, new TypeReference<Foo<User>>() {
        });
        System.out.println(foo.toString());
        System.out.println(foo.getObj().getClass());
    }
}