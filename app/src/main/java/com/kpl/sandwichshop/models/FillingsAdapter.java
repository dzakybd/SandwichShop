package com.kpl.sandwichshop.models;

/**
 * Created by herdito on 12/4/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kpl.sandwichshop.R;

import java.util.List;


public class FillingsAdapter extends RecyclerView.Adapter<FillingsAdapter.ViewHolder> {

    private List<Filling> fillingsList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name, price, category;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.text_name);
            price = view.findViewById(R.id.text_price);
            category = view.findViewById(R.id.text_category);
        }

    }

    public FillingsAdapter(List<Filling> fillingsList) {
        this.fillingsList = fillingsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_filling, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Filling filling = fillingsList.get(position);
        holder.name.setText(filling.getName());
        holder.price.setText(String.valueOf(filling.getPrice()));
        holder.category.setText(filling.getCategory());
    }

    @Override
    public int getItemCount() {
        return fillingsList.size();
    }
}