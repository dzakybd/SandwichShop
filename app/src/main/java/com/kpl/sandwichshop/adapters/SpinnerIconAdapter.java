package com.kpl.sandwichshop.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.models.bread.Bread;

import java.util.ArrayList;

/**
 * Created by zaki on 4/12/17.
 */

public class SpinnerIconAdapter extends ArrayAdapter<Bread> {

    int groupid;
    ArrayList<Bread> breads;
    LayoutInflater inflater;

    public SpinnerIconAdapter(Activity context, int groupid, int id, ArrayList<Bread> breads) {
        super(context, id, breads);
        this.breads = breads;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.groupid = groupid;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = inflater.inflate(groupid, parent, false);
        ImageView imageView = itemView.findViewById(R.id.img);
        imageView.setImageResource(breads.get(position).getDrawable());
        TextView textView = itemView.findViewById(R.id.txt);
        textView.setText(breads.get(position).getName());
        return itemView;
    }

    public View getDropDownView(int position, View convertView, ViewGroup
            parent) {
        return getView(position, convertView, parent);

    }
}
