package com.kpl.sandwichshop.activities;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;


import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.adapters.SpinnerIconAdapter;
import com.kpl.sandwichshop.models.Bread.Bread;
import com.kpl.sandwichshop.models.Bread.Bun;
import com.kpl.sandwichshop.models.Bread.Flat;
import com.kpl.sandwichshop.models.Bread.Long;

import java.util.ArrayList;

/**
 * Created by zaki on 4/12/17.
 */


public class SandwichActivity extends AppCompatActivity {

    private Spinner spinnerbread;
    private RecyclerView recyclerfilling;
    private EditText edittextcoupon;
    private TextView textviewprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwich);
        textviewprice = findViewById(R.id.textview_price);
        edittextcoupon = findViewById(R.id.edittext_coupon);
        recyclerfilling = findViewById(R.id.recycler_filling);
        spinnerbread = findViewById(R.id.spinner_bread);

        spinnerSetup();
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
    }

    public void addFilling(View view) {
    }

    public void addCoupon(View view) {
    }

    public void grabSandwich(View view) {
    }


}
