package io.github.evertton.tint.io.github.evertton.tint.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.TwoLineListItem;

import java.util.ArrayList;

public class PaletaAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Paleta> paletas;

    public PaletaAdapter(Context context, ArrayList<Paleta> paletas) {
        this.context = context;
        this.paletas = paletas;
    }

    @Override
    public int getCount() {
        return paletas.size();
    }

    @Override
    public Object getItem(int position) {
        return paletas.get(position);
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

        TextView text1 = twoLineListItem.getText1();

        text1.setText(paletas.get(position).getNome());

        return twoLineListItem;
    }


}
