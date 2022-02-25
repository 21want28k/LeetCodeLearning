package com.company.design.template;

public class Client {
    public static void main(String[] args) {
        GoOnlineHelper chromeHelper = new ChromeHelper(true);
        GoOnlineHelper firefoxHelper = new FireFoxHelper(false);
        chromeHelper.surfTheInternet();
        firefoxHelper.surfTheInternet();
    }
}