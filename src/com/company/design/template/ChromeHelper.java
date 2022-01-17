package com.company.design.template;

public class ChromeHelper extends GoOnlineHelper {

    public ChromeHelper(boolean logoutFlag) {
        super(logoutFlag);
    }

    @Override
    void login() {
        System.out.println("chrome help you login");
    }

    @Override
    void scan() {
        System.out.println("chrome help you scan");
    }

    @Override
    void logout() {
        System.out.println("chrome help you logout");
    }
}
