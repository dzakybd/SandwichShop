package com.kpl.sandwichshop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.kpl.sandwichshop.Order;
import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;
import com.kpl.sandwichshop.Sandwich;
import com.kpl.sandwichshop.decorator.CheeseDecorator;
import com.kpl.sandwichshop.decorator.MayoDecorator;
import com.kpl.sandwichshop.decorator.SauceDecorator;

import org.parceler.Parcels;

/**
 * Created by Ilham Aulia Majid on 01-Dec-17.
 */

public class ToppingActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = getClass().getSimpleName();

    private TextView textViewPriceTopping;
    private TextView textViewPriceTotal;
    private TextView textViewPriceSandwich;
    private Button buttonNext;
    private CheckBox checkBoxMayonaise;
    private CheckBox checkBoxCheese;
    private CheckBox checkBoxSauce;

    Order order;
    Sandwich sandwich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topping);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Topping Sandwich");

        order = Parcels.unwrap(getIntent().getParcelableExtra(StaticKeys.ORDER));
        sandwich = order.getSandwich();

        textViewPriceTopping = findViewById(R.id.textview_price_topping);
        textViewPriceSandwich = findViewById(R.id.textview_price_sandwich);
        textViewPriceTotal = findViewById(R.id.textview_price_total);
        buttonNext = findViewById(R.id.button_next_additional);
        checkBoxMayonaise = findViewById(R.id.checkbox_mayonaise);
        checkBoxCheese = findViewById(R.id.checkbox_cheese);
        checkBoxSauce = findViewById(R.id.checkbox_sauce);

        buttonNext.setOnClickListener(this);

        updatePrice();

    }

    public void onCheckboxClicked(View view) {
        sandwich.removeDecorator();
        if (checkBoxMayonaise.isChecked()) {
            sandwich.addDecorator(new MayoDecorator());
        }
        if (checkBoxCheese.isChecked()) {
            sandwich.addDecorator(new CheeseDecorator());
        }
        if (checkBoxSauce.isChecked()) {
            sandwich.addDecorator(new SauceDecorator());
        }
        updatePrice();
    }

    private void updatePrice() {
        int priceSandwich = sandwich.getSandwichPrice();
        int priceTopping = sandwich.getToppingPrice();
        int total = sandwich.getPrice();

        textViewPriceSandwich.setText(Integer.toString(priceSandwich));
        textViewPriceTopping.setText(Integer.toString(priceTopping));
        textViewPriceTotal.setText(Integer.toString(total));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_next_additional:
                Intent intent = new Intent(this, BonusActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable(StaticKeys.ORDER, Parcels.wrap(Order.class, order));
                intent.putExtras(bundle);
                startActivity(intent);
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
