package com.tw.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tw.domain.EventInfo;
import com.tw.utilities.JSONUtil;

import java.util.List;

import static android.view.ViewGroup.LayoutParams.FILL_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.widget.LinearLayout.VERTICAL;

public class DisplayEvent extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        String jsonResponse = bundle.getString("jsonResponse");
        LinearLayout linearLayout = new LinearLayout(this);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(FILL_PARENT, WRAP_CONTENT);
        linearLayout.setLayoutParams(params);
        linearLayout.setOrientation(VERTICAL);
        addEventInfos(JSONUtil.constructEventInfo(jsonResponse), linearLayout);
        setContentView(linearLayout);
    }

    private void addEventInfos(List<EventInfo> eventInfos, LinearLayout linearLayout) {
        for (EventInfo eventInfo : eventInfos) {
            linearLayout.addView(textView(eventInfo.getName()));
            linearLayout.addView(textView(eventInfo.getWhat()));
            linearLayout.addView(textView(eventInfo.getWhen()));
            linearLayout.addView(textView(eventInfo.getWhere()));
        }
    }

    private TextView textView(String text) {
        TextView textView = new TextView(this);
        textView.setText(text);
        return textView;
    }
}