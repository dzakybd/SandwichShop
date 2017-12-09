package com.kpl.sandwichshop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.decorator.CheeseDecorator;
import com.kpl.sandwichshop.decorator.Decorator;
import com.kpl.sandwichshop.decorator.MayoDecorator;
import com.kpl.sandwichshop.decorator.SauceDecorator;

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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Topping Sandwich");

        button_pesan = findViewById(R.id.btn_lanjutkan_additional);
        button_pesan.setOnClickListener(this);

        Decorator decorator = new CheeseDecorator(new MayoDecorator(new SauceDecorator()));
        Log.d(TAG, "onCreate: " + decorator.getName());
        Log.d(TAG, "onCreate: " + decorator.getPrice());
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.check_sauce:
                if (checked){
                    Log.d("CHECKBOX","TERCENTANG SAUCE");
                }
            else{

                }
                break;
            case R.id.check_cheese:
                if (checked){
                    Log.d("CHECKBOX","TERCENTANG CHEESE");
                }
            else{

                }
                break;
            case R.id.check_mayones:
                if (checked){
                    Log.d("CHECKBOX","TERCENTANG MAYONASE");
                }
            else{

                }
                break;
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_lanjutkan_additional:
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
