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

public class BonusActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonNext;
    RadioGroup radioGroupBonus;
    TextView textViewBonus;

    BonusFacade bonusFacade;
    String bonus;
    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Bonus");

        order = new Order();

        buttonNext = findViewById(R.id.button_next_bonus);
        radioGroupBonus = findViewById(R.id.radiogroup_list_bonus);
        textViewBonus = findViewById(R.id.textview_bonus);

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
        radioGroupBonus.check(R.id.radiobutton_cofee);
        buttonNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_next_bonus:
                order.setBonus(bonus);
                Intent intent = new Intent(this, PaymentActivity.class);
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
