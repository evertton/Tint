package io.github.evertton.tint.io.github.evertton.tint.model;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.TwoLineListItem;

import java.util.ArrayList;

public class CorAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> cores;

    public CorAdapter(Context context, ArrayList<String> cores) {
        this.context = context;
        this.cores = cores;
    }

    @Override
    public int getCount() {
        return cores.size();
    }

    @Override
    public Object getItem(int position) {
        return cores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TwoLineListItem twoLineListItem;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            twoLineListItem = (TwoLineListItem) inflater.inflate(
                    android.R.layout.simple_list_item_2, null);
        } else {
            twoLineListItem = (TwoLineListItem) convertView;
        }

        twoLineListItem.setBackgroundColor(Color.parseColor(cores.get(position)));

        TextView text1 = twoLineListItem.getText1();

        text1.setTextColor(Color.rgb(1, 1, 1));
        text1.setText(cores.get(position));

        return twoLineListItem;
    }


}
