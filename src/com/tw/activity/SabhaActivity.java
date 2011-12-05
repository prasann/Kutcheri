package com.tw.activity;

import android.app.ListActivity;
import android.os.Bundle;
import com.tw.R;
import com.tw.adapter.EventListAdapter;
import com.tw.domain.Detail;
import com.tw.utilities.FileUtils;

import java.util.List;

import static com.tw.utilities.JSONUtil.constructItems;

public class SabhaActivity extends ListActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_list);
        String responseBody = FileUtils.getJSONResponse(this.getResources(), R.raw.sabha);
        List<Detail> details = constructItems("sabhas", responseBody);
        EventListAdapter eventListAdapter = new EventListAdapter(this, R.layout.event_row, details);
        this.setListAdapter(eventListAdapter);
    }
}