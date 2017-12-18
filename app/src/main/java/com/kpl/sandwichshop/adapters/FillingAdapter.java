package com.kpl.sandwichshop.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.models.filling.Filling;
import com.mikepenz.fastadapter.commons.utils.FastAdapterUIUtils;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

/**
 * Created by zaki on 4/12/17.
 */

public class FillingAdapter extends AbstractItem<FillingAdapter, FillingAdapter.ViewHolder> {

    public Filling filling;

    public FillingAdapter create(Filling filling) {
        this.filling = filling;
        return this;
    }

    @Override
    public int getType() {
        return R.id.filling_adapter_id;
    }


    @Override
    public int getLayoutRes() {
        return R.layout.item_filling;
    }

    @Override
    public void bindView(FillingAdapter.ViewHolder viewHolder, List<Object> payloads) {
        super.bindView(viewHolder, payloads);

        Context ctx = viewHolder.itemView.getContext();
        viewHolder.view.setForeground(FastAdapterUIUtils.getSelectablePressedBackground(ctx, FastAdapterUIUtils.adjustAlpha(ctx.getResources().getColor(R.color.colorPrimary), 100), 50, true));

        viewHolder.textViewName.setText(String.valueOf(filling.getPrice()));
        viewHolder.textViewName.setText(filling.getName());
        viewHolder.imageViewDrawable.setImageDrawable(ctx.getResources().getDrawable(filling.getDrawable()));

    }

    @Override
    public void unbindView(ViewHolder holder) {
        super.unbindView(holder);
        holder.imageViewDrawable.setImageDrawable(null);
        holder.textViewPrice.setText(null);
        holder.textViewName.setText(null);
    }

    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    /**
     * our ViewHolder
     */
    protected static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewDrawable;
        private TextView textViewName, textViewPrice;
        private FrameLayout view;

        public ViewHolder(View view) {
            super(view);
            this.view = (FrameLayout) view;
            textViewName = view.findViewById(R.id.textview_name);
            textViewPrice = view.findViewById(R.id.textview_price);
            imageViewDrawable = view.findViewById(R.id.imageview_drawable);
        }
    }
}
