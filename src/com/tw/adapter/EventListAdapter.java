package com.tw.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.tw.R;

import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class EventListAdapter extends ArrayAdapter<String> {

    private List<String> items;
    private Context myContext;

    public EventListAdapter(Context context, int textViewResourceId, List<String> items) {
        super(context, textViewResourceId, items);
        this.items = items;
        this.myContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) myContext.getSystemService(LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R.layout.event_row, null);
        }
        String displayName = items.get(position);
        if (displayName != null) {
            TextView displayNameView = (TextView) view.findViewById(R.id.displayName);
            if (displayNameView != null) {
                displayNameView.setText(displayName);
            }
        }
        return view;

    }

}
