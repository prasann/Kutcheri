package com.tw.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;

public abstract class MyTabActivity extends ListActivity {

    public void startEventDisplayActivity(String jsonResponse) {
        Intent intent = new Intent(this, DisplayEvent.class);
        Bundle bundle = new Bundle();
        bundle.putString("jsonResponse", jsonResponse);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
