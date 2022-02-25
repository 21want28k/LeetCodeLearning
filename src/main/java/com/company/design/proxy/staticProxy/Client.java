package com.company.design.proxy.staticProxy;

public class Client {
    public static void main(String[] args) {
        IGamePlayer player = new GamePlayer();
        IGamePlayer proxy = new GamePlayerProxy(player);
        proxy.login("hhg", "111");
        proxy.killBoss();
        proxy.upgrade();

    }
}
