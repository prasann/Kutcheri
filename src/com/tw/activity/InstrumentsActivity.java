package com.tw.activity;

import android.app.ListActivity;
import android.os.Bundle;
import com.tw.R;
import com.tw.adapter.EventListAdapter;
import com.tw.domain.Detail;
import com.tw.utilities.JSONUtil;

import java.util.List;

import static com.tw.utilities.HttpUtils.getJSONResponse;

public class InstrumentsActivity extends ListActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_list);
        String responseBody = getJSONResponse("http://www.ilovemadras.com/api/get_instrument_index");
        List<Detail> details = JSONUtil.constructDetailsForInstruments(responseBody);
        EventListAdapter eventListAdapter = new EventListAdapter(this, R.layout.event_row, details);
        this.setListAdapter(eventListAdapter);
    }
}