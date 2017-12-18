package com.kpl.sandwichshop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.kpl.sandwichshop.Order;
import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;
import com.kpl.sandwichshop.decorator.CheeseDecorator;
import com.kpl.sandwichshop.decorator.MayoDecorator;
import com.kpl.sandwichshop.decorator.SauceDecorator;

import org.parceler.Parcels;

/**
 * Created by Ilham Aulia Majid on 01-Dec-17.
 */

public class ToppingActivity extends AppCompatActivity {

    private TextView textViewPriceTopping;
    private TextView textViewPriceTotal;
    private TextView textViewPriceSandwich;
    private CheckBox checkBoxMayonaise;
    private CheckBox checkBoxCheese;
    private CheckBox checkBoxSauce;

    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topping);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        order = Parcels.unwrap(getIntent().getParcelableExtra(StaticKeys.ORDER));

        textViewPriceTopping = findViewById(R.id.textview_price_topping);
        textViewPriceSandwich = findViewById(R.id.textview_price_sandwich);
        textViewPriceTotal = findViewById(R.id.textview_price_total);
        checkBoxMayonaise = findViewById(R.id.checkbox_mayonaise);
        checkBoxCheese = findViewById(R.id.checkbox_cheese);
        checkBoxSauce = findViewById(R.id.checkbox_sauce);

        updatePrice();
    }

    public void onCheckboxClicked(View view) {
        order.getSandwich().removeDecorator();
        if (checkBoxMayonaise.isChecked()) {
            order.getSandwich().addDecorator(new MayoDecorator());
        }
        if (checkBoxCheese.isChecked()) {
            order.getSandwich().addDecorator(new CheeseDecorator());
        }
        if (checkBoxSauce.isChecked()) {
            order.getSandwich().addDecorator(new SauceDecorator());
        }
        updatePrice();
    }

    private void updatePrice() {
        int priceSandwich = order.getSandwich().getSandwichPrice();
        int priceTopping = order.getSandwich().getToppingPrice();
        int total = order.getSandwich().getPrice();

        textViewPriceSandwich.setText(String.valueOf(priceSandwich));
        textViewPriceTopping.setText(String.valueOf(priceTopping));
        textViewPriceTotal.setText(String.valueOf(total));
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

    public void goToBonus(View view) {
        Intent intent = new Intent(this, BonusActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(StaticKeys.ORDER, Parcels.wrap(Order.class, order));
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
