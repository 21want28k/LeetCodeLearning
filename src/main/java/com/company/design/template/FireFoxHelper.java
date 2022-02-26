package com.company.design.template;

public class FireFoxHelper extends GoOnlineHelper {
    public FireFoxHelper(boolean logoutFlag) {
        super(logoutFlag);
    }

    @Override
    protected void login() {
        System.out.println("firefox help you login");
    }

    @Override
    protected void scan() {
        System.out.println("firefox help you scan");
    }

    @Override
    protected void logout() {
        System.out.println("firefox help you logout");
    }
}