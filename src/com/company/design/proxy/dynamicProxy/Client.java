package com.company.design.proxy.dynamicProxy;

import com.company.design.proxy.staticProxy.GamePlayer;
import com.company.design.proxy.staticProxy.IGamePlayer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        IGamePlayer player = new GamePlayer();
        ClassLoader classLoader = player.getClass().getClassLoader();
        Class<?>[] interfaces = player.getClass().getInterfaces();
        InvocationHandler myLogHandler = new MyLogHandler(player);
        // 利用Proxy生成一个代理
        IGamePlayer playerProxy = (IGamePlayer) Proxy.newProxyInstance(classLoader, interfaces, myLogHandler);
        playerProxy.login("hhg", "123");
        playerProxy.killBoss();
        playerProxy.upgrade();
        // 生成playerProxy.class文件
        ProxyUtils.generateClassFile(playerProxy.getClass(), "playerProxy");

    }
}
