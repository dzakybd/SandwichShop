package com.kpl.sandwichshop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.kpl.sandwichshop.R;

/**
 * Created by Ilham Aulia Majid on 01-Dec-17.
 */

public class AdditionalActivity  extends AppCompatActivity implements View.OnClickListener{

    Button button_pesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional);
        button_pesan = findViewById(R.id.button_pesan);
        button_pesan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_pesan:
                Log.d("Pesanan", "masuk");
                startActivity(new Intent(this, OrderActivity.class));
                break;
        }
    }



}
