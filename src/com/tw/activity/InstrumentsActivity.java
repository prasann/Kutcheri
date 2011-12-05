package com.tw.activity;

import android.app.ListActivity;
import android.os.Bundle;
import com.tw.R;
import com.tw.adapter.EventListAdapter;
import com.tw.domain.Detail;
import com.tw.utilities.FileUtils;
import com.tw.utilities.JSONUtil;

import java.util.List;

public class InstrumentsActivity extends ListActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_list);
        String responseBody = FileUtils.getJSONResponse(this.getResources(), R.raw.instruments);
        List<Detail> details = JSONUtil.constructDetailsForInstruments(responseBody);
        EventListAdapter eventListAdapter = new EventListAdapter(this, R.layout.event_row, details);
        this.setListAdapter(eventListAdapter);
    }
}