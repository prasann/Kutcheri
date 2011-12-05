package com.tw.domain;

public enum Tabs {
    SABHA("sabhas", "get_events_by_sabha", "Loading sabhas ..."),
    INSTRUMENT("instruments", "get_events_by_instrument", "Loading instruments ..."),
    ARTIST("artistes", "get_events_by_artiste", "Loading artists ...");

    private String tagName;
    private String apiName;
    private String progressDialogText;

    Tabs(String tagName, String apiName, String progressDialogText) {
        this.tagName = tagName;
        this.apiName = apiName;
        this.progressDialogText = progressDialogText;
    }

    public String getTagName() {
        return tagName;
    }

    public String getApiName() {
        return apiName;
    }

    public String getProgressDialogText() {
        return progressDialogText;
    }
}
