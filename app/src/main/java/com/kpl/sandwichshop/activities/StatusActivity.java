package com.kpl.sandwichshop.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.kpl.sandwichshop.Order;
import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;

public class StatusActivity extends AppCompatActivity {

    TextView textViewOrderInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        Order order = (Order) getIntent().getExtras().getSerializable(StaticKeys.ORDER);

        textViewOrderInfo = findViewById(R.id.textview_order_info);
        textViewOrderInfo.setText(order.toString());

    }
}
