package com.kpl.sandwichshop.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.models.Filling.Filling;
import com.mikepenz.fastadapter.commons.utils.FastAdapterUIUtils;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

/**
 * Created by zaki on 4/12/17.
 */

public class FillingAdapter extends AbstractItem<FillingAdapter, FillingAdapter.ViewHolder> {

    public Filling filling;

    public FillingAdapter create(Filling filling){
        this.filling = filling;
        return this;
    }

    @Override
    public int getType() {
        return R.id.filling_adapter_id;
    }


    @Override
    public int getLayoutRes() {
        return R.layout.filling_item;
    }

    @Override
    public void bindView(FillingAdapter.ViewHolder viewHolder, List<Object> payloads) {
        super.bindView(viewHolder, payloads);

        Context ctx = viewHolder.itemView.getContext();
        //set the background for the item
        viewHolder.view.setForeground(FastAdapterUIUtils.getSelectablePressedBackground(ctx, FastAdapterUIUtils.adjustAlpha(ctx.getResources().getColor(R.color.colorPrimary), 100), 50, true));

        viewHolder.tvPrice.setText(String.valueOf(filling.getPrice()));
        viewHolder.tvName.setText(filling.getName());
        viewHolder.imageDrawable.setImageDrawable(ctx.getResources().getDrawable(filling.getDrawable()));

    }

    @Override
    public void unbindView(ViewHolder holder) {
        super.unbindView(holder);
        holder.imageDrawable.setImageDrawable(null);
        holder.tvPrice.setText(null);
        holder.tvName.setText(null);
    }

    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    /**
     * our ViewHolder
     */
    protected static class ViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imageDrawable;
        protected TextView tvName,tvPrice;
        protected FrameLayout view;

        public ViewHolder(View view) {
            super(view);
            this.view = (FrameLayout) view;
            tvName=view.findViewById(R.id.textview_name);
            tvPrice=view.findViewById(R.id.textview_price);
            imageDrawable=view.findViewById(R.id.imageview_drawable);
        }
    }
}
