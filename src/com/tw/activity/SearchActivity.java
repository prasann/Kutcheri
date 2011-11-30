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

        addTab(tabHost, "artists", "Artists");
        addTab(tabHost, "instruments", "Instruments");
        addTab(tabHost, "sabha", "Sabha");
    }

    private void addTab(TabHost tabHost, String tabId, String tabDisplayName) {
        Intent intent = new Intent().setClass(this, ArtistsActivity.class);
        TabHost.TabSpec spec = tabHost.newTabSpec(tabId).setIndicator(tabDisplayName).setContent(intent);
        tabHost.addTab(spec);
    }
}