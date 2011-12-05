package com.tw;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.tw.activity.MyTabActivity;
import com.tw.domain.Detail;

import static com.tw.utilities.HttpUtils.getJSONResponse;

public class FetchDetails extends AsyncTask<Void, Void, String> {

    private Detail detail;
    private String api;
    private Activity activity;
    private ProgressDialog myProgressDialog;

    public FetchDetails(Detail detail, String api, Activity activity) {
        this.detail = detail;
        this.api = api;
        this.activity = activity;
    }

    private String fetchDetails() {
        return getJSONResponse("http://www.ilovemadras.com/api/" + api + "?id=" + detail.getId());
    }

    @Override
    protected String doInBackground(Void... voids) {
        return fetchDetails();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        myProgressDialog = ProgressDialog.show(activity,
                "Please wait...", "Loading  information... ", true);
    }

    @Override
    protected void onPostExecute(String returnString) {
        super.onPostExecute(returnString);
        myProgressDialog.dismiss();
        ((MyTabActivity) activity).startEventDisplayActivity(returnString);
    }
}
