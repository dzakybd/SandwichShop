package com.kpl.sandwichshop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.kpl.sandwichshop.Order;
import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;
import com.kpl.sandwichshop.facade.BonusFacade;

import org.parceler.Parcels;

/**
 * Created by Ilham Aulia Majid on 01-Dec-17.
 */

public class BonusActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    RadioGroup radioGroupBonus;
    TextView textViewBonus;
    TextView textViewPrice;

    BonusFacade bonusFacade;
    String bonus;
    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        order = Parcels.unwrap(getIntent().getParcelableExtra(StaticKeys.ORDER));

        textViewBonus = findViewById(R.id.textview_bonus);
        textViewPrice = findViewById(R.id.textview_price);
        radioGroupBonus = findViewById(R.id.radiogroup_list_bonus);

        textViewPrice.setText(String.valueOf(order.getSandwich().getPrice()));

        bonusFacade = new BonusFacade();
        radioGroupBonus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                View radioButton = radioGroup.findViewById(i);
                int index = radioGroup.indexOfChild(radioButton);
                switch (index) {
                    case 0:
                        bonus = bonusFacade.getCoffee();
                        break;
                    case 1:
                        bonus = bonusFacade.getTea();
                        break;
                    case 2:
                        bonus = bonusFacade.getSoftdrink();
                        break;
                }
                textViewBonus.setText(bonus);
            }
        });
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

    public void goToPayment(View view) {
        order.setBonus(bonus);
        Intent intent = new Intent(this, PaymentActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(StaticKeys.ORDER, Parcels.wrap(Order.class, order));
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
