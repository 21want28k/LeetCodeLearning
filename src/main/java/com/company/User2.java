package com.company;

public class User2 implements Comparable<User2>{
    String name;
    @Override
    public int compareTo(User2 other){
        return this.name.compareTo(other.name);
    }

    public static void main(String[] args) {
        Comparable<User2> user = new User2();
        Object other = new User2();
    }
}
