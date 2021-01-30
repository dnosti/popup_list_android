package com.example.test_popuplist_android;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PopUpListAdapter extends BaseAdapter {
    String arr[] = new String[] {"Santa Fe", "Buenos Aires", "Corrientes", "La Pampa", "Entre Ríos", "Chaco", "Misiones", "San Luis"};

    Context _context;

    public PopUpListAdapter(Context context) {
        _context = context;
    }

    @Override
    public int getCount() {
        return arr.length;
    }

    @Override
    public Object getItem(int position) {
        return arr[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView(_context);
        tv.setWidth(400);
        tv.setHeight(50);
        tv.setPadding(15,10,0,0);
        tv.setTextColor(Color.BLUE);
        tv.setText(arr[position]);
        return tv;
    }
}
