package com.kpl.sandwichshop.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kpl.sandwichshop.Order;
import com.kpl.sandwichshop.Payment;
import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;
import com.kpl.sandwichshop.builder.Sandwich;
import com.kpl.sandwichshop.strategy.CardPayment;
import com.kpl.sandwichshop.strategy.CashPayment;

import org.parceler.Parcels;

/**
 * Created by Ilham Aulia Majid on 01-Dec-17.
 */

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = getClass().getSimpleName();

    LinearLayout linearLayoutCash;
    LinearLayout linearLayoutCard;
    TextView textViewPrice;
    TextView textViewValue;
    EditText editTextValue;
    Button buttonPay;

    Payment payment;
    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        order = Parcels.unwrap(getIntent().getParcelableExtra(StaticKeys.ORDER));
        Sandwich sandwich = order.getSandwich();

        payment = new Payment(sandwich);

        linearLayoutCard = findViewById(R.id.linearlayout_card);
        linearLayoutCash = findViewById(R.id.linearlayout_cash);
        textViewPrice = findViewById(R.id.textview_price);
        textViewValue = findViewById(R.id.textview_value);
        editTextValue = findViewById(R.id.edittext_value);
        buttonPay = findViewById(R.id.button_pay);

        textViewPrice.setText("Price : " + sandwich.getPrice());
        linearLayoutCard.setOnClickListener(this);
        linearLayoutCash.setOnClickListener(this);
        buttonPay.setOnClickListener(this);

        selectCash();
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
            case R.id.button_pay:
                pay();
                break;
            case R.id.linearlayout_cash:
                selectCash();
                break;
            case R.id.linearlayout_card:
                selectCard();
                break;
        }
    }

    private void selectCash() {
        linearLayoutCash.setClickable(false);
        linearLayoutCard.setClickable(true);
        textViewValue.setText("Insert your money");
        editTextValue.setText("");
        editTextValue.setHint("Amount");
        payment.setPaymentMethod(new CashPayment());
    }

    private void selectCard() {
        linearLayoutCash.setClickable(true);
        linearLayoutCard.setClickable(false);
        textViewValue.setText("Insert your credit card number");
        editTextValue.setText("");
        editTextValue.setHint("Card number");
        payment.setPaymentMethod(new CardPayment());
    }

    private void pay() {
        if (editTextValue.getText().toString().trim().length() == 0) {
            Toast.makeText(this, "Please fill all box", Toast.LENGTH_SHORT).show();
            return;
        }
        String value = editTextValue.getText().toString();
        payment.setValue(value);
        String message = payment.pay();
        if (message.equals(StaticKeys.CASH_FAILED)) {
            Toast.makeText(this, "Your money is not enough", Toast.LENGTH_SHORT).show();
        } else if (message.equals(StaticKeys.CARD_FAILED)) {
            Toast.makeText(this, "Card number is invalid", Toast.LENGTH_SHORT).show();
        } else {
            order.setPaymentMessage(message);
            showSuccessDialog();
        }
    }

    private void showSuccessDialog() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(PaymentActivity.this, MainActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        };
        mBuilder.setTitle("Payment Success")
                .setMessage(order.toString())
                .setPositiveButton("OK", listener)
                .setCancelable(false);
        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }
}
