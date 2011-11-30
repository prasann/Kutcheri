package com.tw.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import com.tw.R;

public class SearchActivity extends TabActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);

        Resources res = getResources();
        TabHost tabHost = getTabHost();
        TabHost.TabSpec spec;
        Intent intent;

        intent = new Intent().setClass(this, ArtistsActivity.class);
        spec = tabHost.newTabSpec("artists").setIndicator("Artists").setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, InstrumentsActivity.class);
        spec = tabHost.newTabSpec("albums").setIndicator("Instruments").setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, SabhaActivity.class);
        spec = tabHost.newTabSpec("songs").setIndicator("Sabha").setContent(intent);
        tabHost.addTab(spec);

        tabHost.setCurrentTab(2);
    }
}