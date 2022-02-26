package com.company.design.proxy.cglib;

public class MyFastClass {

    public Object invoke(int index, Object o) {
        MyObj obj = (MyObj) o;
        switch (index) {
            case 1:
                obj.f1();
                return null;
            case 2:
                obj.f2();
                return null;
        }
        return null;
    }

    public int getIndex(String signature) {
        switch (signature.hashCode()) {
            // f1()
            case 3087052:
                return 1;
            // f2()
            case 3088013:
                return 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        MyObj obj = new MyObj();
        MyFastClass fastClass = new MyFastClass();
        int f1Index = fastClass.getIndex("f1()");
        int f2Index = fastClass.getIndex("f2()");
        fastClass.invoke(f1Index, obj);
        fastClass.invoke(f2Index, obj);
    }
}

class MyObj {
    public void f1() {
        System.out.println("invoke f1");
    }

    public void f2() {
        System.out.println("invoke f2");
    }
}