package com.tw.domain;

import org.json.JSONException;
import org.json.JSONObject;

public class EventInfo {
    private String name;
    private String when;
    private String where;
    private String what;

    public EventInfo(String name, String when, String where, String what) {
        this.name = name;
        this.when = when;
        this.where = where;
        this.what = what;
    }

    public String getName() {
        return name;
    }

    public String getWhen() {
        return when;
    }

    public String getWhere() {
        return where;
    }

    public String getWhat() {
        return what;
    }

    public static EventInfo getEvent(JSONObject jsonObject) throws JSONException {
        return new EventInfo((String) jsonObject.get("name"),
                (String) jsonObject.get("when"),
                (String) jsonObject.get("where"),
                (String) jsonObject.get("what")
        );
    }
}
