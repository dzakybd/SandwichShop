package com.kpl.sandwichshop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.decorator.CheeseDecorator;
import com.kpl.sandwichshop.decorator.Decorator;
import com.kpl.sandwichshop.decorator.MayoDecorator;

/**
 * Created by Ilham Aulia Majid on 01-Dec-17.
 */

public class AdditionalActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = getClass().getSimpleName();

    Button button_pesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional);
        button_pesan = findViewById(R.id.button_pesan);
        button_pesan.setOnClickListener(this);

        Decorator decorator = new CheeseDecorator(new MayoDecorator());
        Log.d(TAG, "onCreate: " + decorator.getDecorators());
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
