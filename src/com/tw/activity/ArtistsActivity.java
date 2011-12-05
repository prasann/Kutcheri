package com.tw.activity;

import android.app.ListActivity;
import android.os.Bundle;
import com.tw.R;
import com.tw.adapter.EventListAdapter;
import com.tw.domain.Detail;

import java.util.List;

import static com.tw.utilities.FileUtils.getJSONResponse;
import static com.tw.utilities.JSONUtil.constructItems;

public class ArtistsActivity extends ListActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_list);
        String responseBody = getJSONResponse(this.getResources(), R.raw.artist);
        List<Detail> details = constructItems("artistes", responseBody);
        EventListAdapter eventListAdapter = new EventListAdapter(this, R.layout.event_row, details);
        this.setListAdapter(eventListAdapter);
    }
}