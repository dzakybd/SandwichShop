package com.kpl.sandwichshop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.kpl.sandwichshop.R;

/**
 * Created by Ilham Aulia Majid on 01-Dec-17.
 */

public class PaymentActivity  extends AppCompatActivity implements View.OnClickListener{
    LinearLayout creditLayout, cash, credit_card;
    Button bayar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        creditLayout = (LinearLayout) findViewById(R.id.card_payment);
        credit_card = (LinearLayout) findViewById(R.id.credit_card);
        credit_card.setOnClickListener(this);
        cash = (LinearLayout) findViewById(R.id.cash);
        cash.setOnClickListener(this);
        bayar = findViewById(R.id.btn_bayar);
        bayar.setOnClickListener(this);

    }
    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_bayar:
                startActivity(new Intent(this, StatusActivity.class));
                break;
            case R.id.credit_card:
                creditLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.cash:
                startActivity(new Intent(this, StatusActivity.class));
                break;
        }
    }
}
