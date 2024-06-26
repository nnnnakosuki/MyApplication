package com.lzj.myapplication;
import static java.security.AccessController.getContext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyAdapter extends ArrayAdapter {
    private static final String TAG = "MyAdapter";

    public MyAdapter(Context context, int resource, ArrayList<HashMap<String,String>> list){
        super(context, resource, list);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View itemView = convertView;

        if(itemView == null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_item,parent,false);
        }
        Map<String,String> map = (Map<String,String>) getItem(position);
        TextView title = itemView.findViewById(R.id.itemTitle);
        TextView detail = itemView.findViewById(R.id.itemDetail);

        title.setText("Currency:" + map.get("ItemTitle"));
        detail.setText("Rate:" + map.get("ItemDetail"));

        return itemView;
    }
}