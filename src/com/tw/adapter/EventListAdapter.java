package com.tw.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.tw.R;
import com.tw.domain.Detail;

import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class EventListAdapter extends ArrayAdapter<Detail> {

    private List<Detail> items;
    private Context myContext;

    public EventListAdapter(Context context, int textViewResourceId, List<Detail> items) {
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
        Detail detail = items.get(position);
        if (detail != null) {
            TextView title = (TextView) view.findViewById(R.id.title);
            TextView description = (TextView) view.findViewById(R.id.description);
            if (description != null) {
                description.setText(detail.getDescription());
            }
            if (title != null) {
                title.setText(detail.getTitle());
            }
        }
        return view;

    }

}
