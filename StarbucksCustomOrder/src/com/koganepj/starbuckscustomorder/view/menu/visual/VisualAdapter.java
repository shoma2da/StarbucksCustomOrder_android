package com.koganepj.starbuckscustomorder.view.menu.visual;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class VisualAdapter extends ArrayAdapter<String> {
    
    //private LayoutInflater mInflater;
    
    public VisualAdapter(Context context) {
        super(context, android.R.layout.simple_list_item_1);
        //mInflater = LayoutInflater.from(context);
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

}
