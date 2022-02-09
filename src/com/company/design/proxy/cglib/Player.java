package com.company.design.proxy.cglib;

public class Player {
    public void login(String username, String password) {
        System.out.println("欢迎, " + username);
    }

    public void killBoss() {
        System.out.println("正在打怪呢！！！");
    }

    public void upgrade() {
        System.out.println("又升级啦！！！");
    }
}