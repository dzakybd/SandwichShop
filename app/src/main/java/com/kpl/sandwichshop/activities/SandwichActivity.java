package com.kpl.sandwichshop.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;


import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;
import com.kpl.sandwichshop.adapters.FillingAdapter;
import com.kpl.sandwichshop.adapters.SpinnerIconAdapter;
import com.kpl.sandwichshop.models.Bread.Bread;
import com.kpl.sandwichshop.models.Bread.Bun;
import com.kpl.sandwichshop.models.Bread.Flat;
import com.kpl.sandwichshop.models.Bread.Long;
import com.kpl.sandwichshop.models.Filling.Filling;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter_extensions.drag.ItemTouchCallback;
import com.mikepenz.fastadapter_extensions.drag.SimpleDragCallback;
import com.mikepenz.fastadapter_extensions.utilities.DragDropUtil;
import com.mikepenz.itemanimators.SlideDownAlphaAnimator;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zaki on 4/12/17.
 */


public class SandwichActivity extends AppCompatActivity implements ItemTouchCallback {

    private Spinner spinnerbread;
    private RecyclerView recyclerfilling;
    private EditText edittextcoupon;
    private TextView textviewprice;
    FastAdapter<FillingAdapter> mFastAdapter;
    ItemAdapter<FillingAdapter> mItemAdapter;
    private SimpleDragCallback touchCallback;
    private ItemTouchHelper touchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwich);
        textviewprice = findViewById(R.id.textview_price);
        edittextcoupon = findViewById(R.id.edittext_coupon);
        recyclerfilling = findViewById(R.id.recycler_filling);
        spinnerbread = findViewById(R.id.spinner_bread);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        spinnerSetup();
        fillingSetup();
    }

    private void fillingData(List<Filling> fillings) {
        for (Filling filling : fillings) {
            mItemAdapter.add(new FillingAdapter().create(filling));
        }
    }


    private void fillingSetup() {
        mItemAdapter = new ItemAdapter<>();
        mFastAdapter = FastAdapter.with(Arrays.asList(mItemAdapter));
        mFastAdapter.withSelectable(true);
        mFastAdapter.withMultiSelect(true);
        mFastAdapter.withSelectOnLongClick(false);
        recyclerfilling.setLayoutManager(new LinearLayoutManager(this));
        recyclerfilling.setAdapter(mFastAdapter);
        recyclerfilling.setItemAnimator(new SlideDownAlphaAnimator());
        recyclerfilling.getItemAnimator().setAddDuration(500);
        recyclerfilling.getItemAnimator().setRemoveDuration(500);
        touchCallback = new SimpleDragCallback(this);
        touchHelper = new ItemTouchHelper(touchCallback); // Create ItemTouchHelper and pass with parameter the SimpleDragCallback
        touchHelper.attachToRecyclerView(recyclerfilling); // Attach ItemTouchHelper to RecyclerView
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    private void spinnerSetup() {
        ArrayList<Bread> breads=new ArrayList<>();
        breads.add(new Flat());
        breads.add(new Bun());
        breads.add(new Long());
        SpinnerIconAdapter adapter=new SpinnerIconAdapter(this, R.layout.spinner_icon,R.id.txt,breads);
        spinnerbread.setAdapter(adapter);
    }

    public void removeFilling(View view) {
        mFastAdapter.deleteAllSelectedItems();
    }

    public void addFilling(View view) {
        Intent i = new Intent(this, AddFillingActivity.class);
        startActivityForResult(i, StaticKeys.addFillingRequest);
    }

    public void addCoupon(View view) {
    }

    public void grabSandwich(View view) {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == StaticKeys.addFillingRequest) {
                if(data.hasExtra(StaticKeys.addFillingResult)) {
                    Filling filling = Parcels.unwrap(data.getParcelableExtra(StaticKeys.addFillingResult));
                    Toast.makeText(this, filling.getName() + filling.getPrice() + filling.getCategory(), Toast.LENGTH_SHORT).show();
                    mItemAdapter.add(new FillingAdapter().create(filling));
                }
            }
        }
    }

    @Override
    public boolean itemTouchOnMove(int oldPosition, int newPosition) {
        DragDropUtil.onMove(mItemAdapter, oldPosition, newPosition);  // change position
        return true;
    }

    @Override
    public void itemTouchDropped(int oldPosition, int newPosition) {
        // save the new item order, i.e. in your database
    }
}
