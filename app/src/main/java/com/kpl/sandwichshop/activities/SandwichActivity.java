package com.kpl.sandwichshop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;
import com.kpl.sandwichshop.adapters.FillingAdapter;
import com.kpl.sandwichshop.adapters.SpinnerIconAdapter;
import com.kpl.sandwichshop.builder.Sandwich;
import com.kpl.sandwichshop.models.Bread.Bread;
import com.kpl.sandwichshop.models.Bread.BunBread;
import com.kpl.sandwichshop.models.Bread.FlatBread;
import com.kpl.sandwichshop.models.Bread.LongBread;
import com.kpl.sandwichshop.models.Filling.Filling;
import com.kpl.sandwichshop.singleton.Discount;
import com.kpl.sandwichshop.singleton.DiscountList;
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

    private Spinner spinnerBread;
    private RecyclerView recyclerViewFilling;
    private EditText editTextCoupon;
    private TextView textViewPrice, textViewDiscount;
    FastAdapter<FillingAdapter> mFastAdapter;
    ItemAdapter<FillingAdapter> mItemAdapter;
    private SimpleDragCallback touchCallback;
    private ItemTouchHelper touchHelper;
    ArrayList<Bread> breads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwich);
        textViewPrice = findViewById(R.id.textview_price);
        textViewDiscount = findViewById(R.id.textview_discount);
        editTextCoupon = findViewById(R.id.edittext_coupon);
        recyclerViewFilling = findViewById(R.id.recycler_filling);
        spinnerBread = findViewById(R.id.spinner_bread);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        spinnerSetup();
        fillingSetup();
    }


    private void fillingSetup() {
        mItemAdapter = new ItemAdapter<>();
        mFastAdapter = FastAdapter.with(Arrays.asList(mItemAdapter));
        mFastAdapter.withSelectable(true);
        mFastAdapter.withMultiSelect(true);
        mFastAdapter.withSelectOnLongClick(false);
        recyclerViewFilling.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewFilling.setAdapter(mFastAdapter);
        recyclerViewFilling.setItemAnimator(new SlideDownAlphaAnimator());
        recyclerViewFilling.getItemAnimator().setAddDuration(500);
        recyclerViewFilling.getItemAnimator().setRemoveDuration(500);
        touchCallback = new SimpleDragCallback(this);
        touchHelper = new ItemTouchHelper(touchCallback); // Create ItemTouchHelper and pass with parameter the SimpleDragCallback
        touchHelper.attachToRecyclerView(recyclerViewFilling); // Attach ItemTouchHelper to RecyclerView
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
        breads = new ArrayList<>();
        breads.add(new FlatBread());
        breads.add(new BunBread());
        breads.add(new LongBread());
        SpinnerIconAdapter adapter = new SpinnerIconAdapter(this, R.layout.spinner_icon, R.id.txt, breads);
        spinnerBread.setAdapter(adapter);
    }

    public void removeFilling(View view) {
        mFastAdapter.deleteAllSelectedItems();
    }

    public void addFilling(View view) {
        Intent i = new Intent(this, AddFillingActivity.class);
        startActivityForResult(i, StaticKeys.ADD_FILLING_REQUEST);
    }

    public void addCoupon(View view) {
        DiscountList.checkDiscount(editTextCoupon.getText().toString());
        calculatePrice();
    }


    public void grabSandwich(View view) {
        if (mItemAdapter.getAdapterItems().size() > 0) {
            Sandwich sandwich = Sandwich.getSandwich();
            sandwich.setBread(breads.get(spinnerBread.getSelectedItemPosition()));
            List<Filling> fillings = new ArrayList<>();
            for (FillingAdapter fillingAdapter : mItemAdapter.getAdapterItems()) {
                fillings.add(fillingAdapter.filling);
            }
            sandwich.setFillings(fillings);
            startActivity(new Intent(this, AdditionalActivity.class));
        } else {
            Toast.makeText(view.getContext(), "Please add the fillings!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == StaticKeys.ADD_FILLING_REQUEST && data.hasExtra(StaticKeys.ADD_FILLING_RESULT)) {
            Filling filling = Parcels.unwrap(data.getParcelableExtra(StaticKeys.ADD_FILLING_RESULT));
            mItemAdapter.add(new FillingAdapter().create(filling));
            calculatePrice();
        }
    }

    private void calculatePrice() {
        int total = 0;
        for (FillingAdapter fillingAdapter : mItemAdapter.getAdapterItems()) {
            total += fillingAdapter.filling.getPrice();
        }
        Discount discount = Discount.getDiscount();
        if (total > discount.getPrice()) {
            total -= discount.getPrice();
            textViewDiscount.setText("" + discount.getPrice());
        } else {
            textViewDiscount.setText("need more items");
        }
        textViewPrice.setText("" + total);
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
