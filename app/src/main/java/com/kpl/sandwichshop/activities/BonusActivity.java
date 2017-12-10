package com.kpl.sandwichshop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.kpl.sandwichshop.R;

/**
 * Created by Ilham Aulia Majid on 01-Dec-17.
 */

public class BonusActivity  extends AppCompatActivity implements View.OnClickListener{
    Button buttonLanjutkan;
    RadioGroup rgBonus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Bonus");

        buttonLanjutkan=(Button)findViewById(R.id.btn_lanjutkan_bonus);
        rgBonus= (RadioGroup) findViewById(R.id.radiogroup_list_bonus);

        rgBonus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                View radioButton = radioGroup.findViewById(i);
                int index = radioGroup.indexOfChild(radioButton);
                Log.d("i", String.valueOf(i));
                Log.d("index", String.valueOf(index));
                Log.d("RadioButton", String.valueOf(radioButton));
                RadioButton rbSelected = (RadioButton) radioGroup.getChildAt(index);
                String selection = (String) rbSelected.getText();
                Log.d("Selction Tetx", String.valueOf(selection));
            }
        });
        buttonLanjutkan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_lanjutkan_bonus:
                Log.d("s","d");
                startActivity(new Intent(this, PaymentActivity.class));
                Log.d("s","d");
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
