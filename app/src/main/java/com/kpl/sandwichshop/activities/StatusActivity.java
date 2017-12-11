package com.kpl.sandwichshop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;

public class StatusActivity extends AppCompatActivity {

    TextView textViewPaymentMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        String paymentMessage = getIntent().getExtras().getString(StaticKeys.PAYMENT_MESSAGE);

        textViewPaymentMessage = findViewById(R.id.textview_payment_message);
        textViewPaymentMessage.setText(paymentMessage);

    }
}
