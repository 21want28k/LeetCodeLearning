package com.company.design.template;

public class FireFoxHelper extends GoOnlineHelper {
    public FireFoxHelper(boolean logoutFlag) {
        super(logoutFlag);
    }

    @Override
    void login() {
        System.out.println("firefox help you login");
    }

    @Override
    void scan() {
        System.out.println("firefox help you scan");
    }

    @Override
    void logout() {
        System.out.println("firefox help you logout");
    }
}
