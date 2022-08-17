package com.email.model;

import java.util.List;

public class EmailForm {
    private List<Language> languages;
    private List<PageSize> pageSizes;
    private boolean spamsFilter;
    private String signature;

    public EmailForm() {
    }

    public EmailForm(List<Language> languages, List<PageSize> pageSizes, boolean spamsFilter, String signature) {
        this.languages = languages;
        this.pageSizes = pageSizes;
        this.spamsFilter = spamsFilter;
        this.signature = signature;
    }

    public EmailForm(List<Language> languages, List<PageSize> pageSizes) {
        this.languages = languages;
        this.pageSizes = pageSizes;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<PageSize> getPageSizes() {
        return pageSizes;
    }

    public void setPageSizes(List<PageSize> pageSizes) {
        this.pageSizes = pageSizes;
    }

    public boolean getSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(boolean spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
