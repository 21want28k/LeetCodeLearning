package com.company.design.proxy;

public class GamePlayer implements IGamePlayer {
    @Override
    public void login(String username, String password) {
        System.out.println("欢迎, " + username);
    }

    @Override
    public void killBoss() {
        System.out.println("正在打怪呢！！！");
    }

    @Override
    public void upgrade() {
        System.out.println("又升级啦！！！");
    }
}
