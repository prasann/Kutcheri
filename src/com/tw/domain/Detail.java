package com.tw.domain;

import org.json.JSONObject;

public class Detail {
    private Integer id;
    private String slug;
    private String title;
    private String description;
    private Integer count;

    public Detail(Integer id, String slug, String title, String description, Integer count) {
        this.id = id;
        this.slug = slug;
        this.title = title;
        this.description = description;
        this.count = count;
    }

    public static Detail getDetail(JSONObject jsonObject) throws Exception {
        return new Detail((Integer) jsonObject.get("id"),
                (String) jsonObject.get("slug"),
                (String) jsonObject.get("title"),
                (String) jsonObject.get("description"),
                (Integer) jsonObject.get("post_count"));
    }


    public long getId() {
        return id;
    }

    public String getSlug() {
        return slug;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCount() {
        return count;
    }
}
