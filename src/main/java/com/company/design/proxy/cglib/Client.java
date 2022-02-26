package com.company.design.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;

public class Client {
    public static void main(String[] args) {
        String path = Player.class.getResource("").getPath();

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, path);
        Player player = new Player();
        Player proxy = (Player) new MyProxyFactory(player).getProxy();
        proxy.login("xx", "123");
        proxy.killBoss();
        proxy.upgrade();
    }
}