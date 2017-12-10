package com.kpl.sandwichshop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

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
    Decorator toppingDecorator;

    private TextView textViewHargaToping;
    private TextView textViewHargaTotal;
    private TextView textViewHargaSandwich;
    private Button button_pesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Topping Sandwich");

        button_pesan = findViewById(R.id.btn_lanjutkan_additional);
        textViewHargaToping=findViewById(R.id.tv_harga_toping);
        textViewHargaSandwich=findViewById(R.id.tv_harga_sandwich);
        textViewHargaTotal=findViewById(R.id.tv_harga_total);
        textViewHargaSandwich.setText(Integer.toString(20000)); //20000 = nilai awal sandwich
        textViewHargaTotal.setText(Integer.toString(20000));

        button_pesan.setOnClickListener(this);

    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.check_sauce:
                if (checked){
                    toppingDecorator=new SauceDecorator(this.toppingDecorator);
                    Log.d("CHECKBOX","TERCENTANG SAUCE");
                }
                else{
                    Log.d("UNCHECKBOX","TERCENTANG SAUCE");
                }
                break;
            case R.id.check_cheese:
                if (checked){
                    toppingDecorator=new CheeseDecorator(this.toppingDecorator);
                    Log.d("CHECKBOX","TERCENTANG CHEESE");
                }
                break;
            case R.id.check_mayones:
                if (checked){
                    toppingDecorator=new MayoDecorator(this.toppingDecorator);
                    Log.d("CHECKBOX","TERCENTANG MAYONASE");
                }
                break;
        }
        updateHarga(toppingDecorator.getPrice());
    }
    private void updateHarga(int harga_topping){
        int hargaSandwich=20000;
        int hargaTopping=harga_topping;
        int total=hargaSandwich+harga_topping;

        textViewHargaSandwich.setText(Integer.toString(hargaSandwich));
        textViewHargaToping.setText(Integer.toString(hargaTopping));
        textViewHargaTotal.setText(Integer.toString(total));
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
