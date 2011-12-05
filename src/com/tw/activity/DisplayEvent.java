package com.tw.activity;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tw.R;
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
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        addEventInfos(JSONUtil.constructEventInfo(jsonResponse), linearLayout);
        setContentView(linearLayout);
    }

    private void addEventInfos(List<EventInfo> eventInfos, LinearLayout linearLayout) {
        for (EventInfo eventInfo : eventInfos) {
            linearLayout.addView(name(eventInfo));
            linearLayout.addView(when(eventInfo));
            linearLayout.addView(where(eventInfo));
            linearLayout.addView(what(eventInfo));
            linearLayout.addView(lineSeparator());
        }
    }

    private TextView name(EventInfo eventInfo) {
        TextView textView = textView(eventInfo.getName());
        textView.setTypeface(null, Typeface.BOLD);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        textView.setTextColor(R.color.black);
        return textView;
    }

    private TextView when(EventInfo eventInfo) {
        TextView textView = textView(eventInfo.getWhen());
        textView.setTypeface(null, Typeface.BOLD);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        textView.setTextColor(R.color.black);
        return textView;
    }

    private TextView where(EventInfo eventInfo) {
        TextView textView = textView(eventInfo.getWhere());
        textView.setTextColor(R.color.grey);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        return textView;
    }

    private TextView what(EventInfo eventInfo) {
        TextView textView = textView(eventInfo.getWhat());
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        textView.setTextColor(R.color.black);
        return textView;
    }

    private TextView textView(String text) {
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        return textView;
    }

    private View lineSeparator() {
        View ruler = new View(this);
        ruler.setBackgroundColor(R.color.black);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 1);
        ruler.setLayoutParams(layoutParams);
        return ruler;
    }
}