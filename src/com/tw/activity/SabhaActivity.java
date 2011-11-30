package com.tw.activity;

import android.app.ListActivity;
import android.os.Bundle;
import com.tw.R;
import com.tw.adapter.EventListAdapter;

import java.util.ArrayList;
import java.util.List;

public class SabhaActivity extends ListActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_list);
        List<String> items = new ArrayList<String>() {
            {
                add("Sabha1");
                add("Sabha2");
                add("Sabha3");
                add("Sabha4");
                add("Sabha5");
            }
        };
        EventListAdapter eventListAdapter = new EventListAdapter(this, R.layout.event_row, items);
        this.setListAdapter(eventListAdapter);
    }
}