package com.kpl.sandwichshop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.kpl.sandwichshop.R;

/**
 * Created by Ilham Aulia Majid on 01-Dec-17.
 */

public class BonusActivity  extends AppCompatActivity implements View.OnClickListener{
    Button buttonLanjutkan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Bonus");

        buttonLanjutkan=(Button)findViewById(R.id.btn_lanjutkan_bonus);
        buttonLanjutkan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_lanjutkan_bonus:
                Log.d("s","d");
                startActivity(new Intent(this, OrderActivity.class));
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
