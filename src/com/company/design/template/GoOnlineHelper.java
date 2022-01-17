package com.company.design.template;

public abstract class GoOnlineHelper {

    boolean logoutFlag;

    GoOnlineHelper(boolean logoutFlag) {
        this.logoutFlag = logoutFlag;
    }

    boolean logoutOrNot() {
        return this.logoutFlag;
    }

    abstract void login();

    abstract void scan();

    abstract void logout();

    protected final void surfTheInternet() {
        this.login();
        this.scan();
        if (logoutOrNot()) {
            this.logout();
        }
    }

    public boolean isLogoutFlag() {
        return logoutFlag;
    }

    public void setLogoutFlag(boolean logoutFlag) {
        this.logoutFlag = logoutFlag;
    }
}