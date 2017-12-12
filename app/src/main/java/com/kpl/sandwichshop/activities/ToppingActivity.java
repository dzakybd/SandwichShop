package com.kpl.sandwichshop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.decorator.CheeseDecorator;
import com.kpl.sandwichshop.decorator.Decorator;
import com.kpl.sandwichshop.decorator.MayoDecorator;
import com.kpl.sandwichshop.decorator.SauceDecorator;

/**
 * Created by Ilham Aulia Majid on 01-Dec-17.
 */

public class ToppingActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = getClass().getSimpleName();
    Decorator toppingDecorator;

    private TextView textViewPriceTopping;
    private TextView textViewPriceTotal;
    private TextView textViewPriceSandwich;
    private Button buttonNext;
    private CheckBox checkBoxMayonaise;
    private CheckBox checkBoxCheese;
    private CheckBox checkBoxSauce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topping);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Topping Sandwich");

        toppingDecorator = new SauceDecorator();

        textViewPriceTopping = findViewById(R.id.textview_price_topping);
        textViewPriceSandwich = findViewById(R.id.textview_price_sandwich);
        textViewPriceTotal = findViewById(R.id.textview_price_total);
        buttonNext = findViewById(R.id.button_next_additional);
        checkBoxMayonaise = findViewById(R.id.checkbox_mayonaise);
        checkBoxCheese = findViewById(R.id.checkbox_cheese);
        checkBoxSauce = findViewById(R.id.checkbox_sauce);

        textViewPriceSandwich.setText(Integer.toString(20000)); //20000 = nilai awal sandwich
        textViewPriceTotal.setText(Integer.toString(20000));

        buttonNext.setOnClickListener(this);

    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        /*if (checked) {
            switch (view.getId()) {
                case R.id.checkbox_sauce:
//                if (checked) {
                    toppingDecorator = new SauceDecorator(this.toppingDecorator);
//                }
                    break;
                case R.id.checkbox_cheese:
//                if (checked) {
                    toppingDecorator = new CheeseDecorator(this.toppingDecorator);
//                }
                    break;
                case R.id.checkbox_mayonaise:
//                if (checked) {
                    toppingDecorator = new MayoDecorator(this.toppingDecorator);
//                }
                    break;
            }
        }*/
        update();
//        updatePrice(toppingDecorator.getPrice());
    }

    private void update() {
        toppingDecorator = new SauceDecorator();
        if (checkBoxMayonaise.isChecked()) {
            toppingDecorator.addDecorator(new MayoDecorator());
        }
        if (checkBoxCheese.isChecked()) {
            toppingDecorator.addDecorator(new CheeseDecorator());
        }
        if (checkBoxSauce.isChecked()) {
            toppingDecorator.addDecorator(new SauceDecorator());
        }
        Log.d(TAG, "update: " + toppingDecorator.getPrice());
    }

    private void updatePrice(int price_topping) {
        int priceSandwich = 20000;
        int priceTopping = price_topping;
        int total = priceSandwich + price_topping;

        textViewPriceSandwich.setText(Integer.toString(priceSandwich));
        textViewPriceTopping.setText(Integer.toString(priceTopping));
        textViewPriceTotal.setText(Integer.toString(total));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_next_additional:
                startActivity(new Intent(this, BonusActivity.class));
                break;
        }
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
}
