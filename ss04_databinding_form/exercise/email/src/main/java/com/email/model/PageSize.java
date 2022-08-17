package com.email.model;

public class PageSize {
    private String emailsPerPage;

    public PageSize() {
    }

    public String getEmailsPerPage() {
        return emailsPerPage;
    }

    public void setEmailsPerPage(String emailsPerPage) {
        this.emailsPerPage = emailsPerPage;
    }

    public PageSize(String emailsPerPage) {
        this.emailsPerPage = emailsPerPage;
    }

    @Override
    public String toString() {
        return emailsPerPage;
    }
}
