package com.tw.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TabHost;
import com.tw.R;

public class SearchActivity extends TabActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);

        TabHost tabHost = getTabHost();

        addTab(tabHost, "artists", "Artists", ArtistsActivity.class, getResources().getDrawable(R.drawable.ic_tab_artist));
        addTab(tabHost, "instruments", "Instruments", InstrumentsActivity.class, getResources().getDrawable(R.drawable.ic_tab_instrument));
        addTab(tabHost, "sabha", "Sabha", SabhaActivity.class, getResources().getDrawable(R.drawable.ic_tab_sabha));
    }

    private void addTab(TabHost tabHost, String tabId, String tabDisplayName, Class className, Drawable icon) {
        Intent intent = new Intent().setClass(this, className);
        TabHost.TabSpec spec = tabHost.newTabSpec(tabId).setIndicator(tabDisplayName, icon).setContent(intent);
        tabHost.addTab(spec);
    }
}