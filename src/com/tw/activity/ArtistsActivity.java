package com.tw.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.tw.FetchDetails;
import com.tw.R;
import com.tw.adapter.EventListAdapter;
import com.tw.domain.Detail;

import java.util.List;

import static com.tw.domain.Tabs.ARTIST;
import static com.tw.utilities.FileUtils.getJSONResponse;
import static com.tw.utilities.JSONUtil.constructItems;

public class ArtistsActivity extends MyTabActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_list);
        String responseBody = getJSONResponse(this.getResources(), R.raw.artist);
        List<Detail> details = constructItems(ARTIST.getTagName(), responseBody);
        EventListAdapter eventListAdapter = new EventListAdapter(this, R.layout.event_row, details);
        this.setListAdapter(eventListAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Detail detail = (Detail) this.getListAdapter().getItem(position);
        new FetchDetails(detail, ARTIST, this).execute();
    }
}