package com.example.textutilities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemsAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    String[] functions;
    String[] descriptions;
    public ItemsAdapter(Context c, String[] functions ,String[] descriptions  ){
        this.functions=functions;
        this.descriptions=descriptions;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return functions.length;
    }

    @Override
    public Object getItem(int i) {
        return functions[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = mInflater.inflate(R.layout.main_list_view,null);
        TextView funcText = (TextView) view.findViewById(R.id.func);
        TextView descriptionText = (TextView) view.findViewById(R.id.description);

        String funcName = functions[i];
        String descriptionName = descriptions[i];
        funcText.setText(funcName);
        descriptionText.setText(descriptionName);

        return view;
    }
}
