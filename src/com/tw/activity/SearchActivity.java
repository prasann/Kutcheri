package com.tw.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import com.tw.R;

public class SearchActivity extends TabActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);

        TabHost tabHost = getTabHost();

        addTab(tabHost, "artists", "Artists", ArtistsActivity.class);
        addTab(tabHost, "instruments", "Instruments", InstrumentsActivity.class);
        addTab(tabHost, "sabha", "Sabha", SabhaActivity.class);
    }

    private void addTab(TabHost tabHost, String tabId, String tabDisplayName, Class className) {
        Intent intent = new Intent().setClass(this, className);
        TabHost.TabSpec spec = tabHost.newTabSpec(tabId).setIndicator(tabDisplayName).setContent(intent);
        tabHost.addTab(spec);
    }
}