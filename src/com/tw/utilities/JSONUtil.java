package com.tw.utilities;

import com.tw.domain.Detail;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.tw.domain.Detail.getDetail;

public class JSONUtil {
    public static List<Detail> constructDetailsForInstruments(String responseBody) {
        List<Detail> details = new ArrayList<Detail>();
        try {
            JSONObject jsonObject = new JSONObject(responseBody).getJSONObject("instruments");
            Iterator keys = jsonObject.keys();
            while (keys.hasNext()) {
                details.add(getDetail(jsonObject.getJSONObject((String) keys.next())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return details;
    }

    public static List<Detail> constructItems(String tagName, String responseBody) {
        List<Detail> details = new ArrayList<Detail>();
        try {
            JSONArray jsonArray = new JSONObject(responseBody).getJSONArray(tagName);
            for (int i = 0; i < jsonArray.length(); i++) {
                details.add(getDetail(jsonArray.getJSONObject(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return details;
    }
}