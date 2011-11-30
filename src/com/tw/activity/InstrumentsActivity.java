package com.tw.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class InstrumentsActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textview = new TextView(this);
        textview.setText("This is the Instruments tab");
        setContentView(textview);
    }
}