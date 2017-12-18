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

    private int groupId;
    private ArrayList<Bread> breads;
    private LayoutInflater inflater;

    public SpinnerIconAdapter(Activity context, int groupId, int id, ArrayList<Bread> breads) {
        super(context, id, breads);
        this.breads = breads;
        this.groupId = groupId;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = inflater.inflate(groupId, parent, false);
        ImageView imageViewDrawable = itemView.findViewById(R.id.imageview_drawable);
        imageViewDrawable.setImageResource(breads.get(position).getDrawable());
        TextView textViewTitle = itemView.findViewById(R.id.textview_title);
        textViewTitle.setText(breads.get(position).getName());
        return itemView;
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }
}
