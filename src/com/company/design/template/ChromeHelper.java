package com.company.design.template;

public class ChromeHelper extends GoOnlineHelper {

    public ChromeHelper(boolean logoutFlag) {
        super(logoutFlag);
    }

    @Override
    protected void login() {
        System.out.println("chrome help you login");
    }

    @Override
    protected void scan() {
        System.out.println("chrome help you scan");
    }

    @Override
    protected void logout() {
        System.out.println("chrome help you logout");
    }
}
