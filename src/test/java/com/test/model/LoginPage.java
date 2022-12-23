package com.test.model;

public class LoginPage {
    private String title;
    private boolean pageHeader;
    private boolean usernameLabel;
    private boolean passwordLabel;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isPageHeader() {
        return pageHeader;
    }

    public void setPageHeader(boolean pageHeader) {
        this.pageHeader = pageHeader;
    }

    public boolean isUsernameLabel() {
        return usernameLabel;
    }

    public void setUsernameLabel(boolean usernameLabel) {
        this.usernameLabel = usernameLabel;
    }

    public boolean isPasswordLabel() {
        return passwordLabel;
    }

    public void setPasswordLabel(boolean passwordLabel) {
        this.passwordLabel = passwordLabel;
    }
}
