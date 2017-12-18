package com.kpl.sandwichshop.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kpl.sandwichshop.Order;
import com.kpl.sandwichshop.strategy.Payment;
import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;
import com.kpl.sandwichshop.strategy.CardPayment;
import com.kpl.sandwichshop.strategy.CashPayment;

import org.parceler.Parcels;

/**
 * Created by Ilham Aulia Majid on 01-Dec-17.
 */

public class PaymentActivity extends AppCompatActivity {

    TextView textViewPrice;

    LinearLayout linearLayoutCash;
    LinearLayout linearLayoutCashDetail;
    EditText editTextValue;

    LinearLayout linearLayoutCard;
    LinearLayout linearLayoutCardDetail;
    EditText editTextNumber;
    EditText editTextCvc;
    EditText editTextExpiredDate;

    Payment payment;
    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        linearLayoutCard = findViewById(R.id.linearlayout_card);
        linearLayoutCash = findViewById(R.id.linearlayout_cash);
        linearLayoutCashDetail = findViewById(R.id.linerLayout_cash_detail);
        editTextNumber=findViewById(R.id.edittext_number);
        editTextCvc=findViewById(R.id.edittext_cvc);
        editTextExpiredDate=findViewById(R.id.edittext_expired_date);
        linearLayoutCardDetail = findViewById(R.id.linerLayout_card_detail);
        textViewPrice = findViewById(R.id.textview_price);
        editTextValue = findViewById(R.id.edittext_value);

        order = Parcels.unwrap(getIntent().getParcelableExtra(StaticKeys.ORDER));
        payment = new Payment(order.getSandwich());
        textViewPrice.setText("Price : " + order.getSandwich().getPrice());
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

    public void selectCash(View view) {
        linearLayoutCash.setClickable(false);
        linearLayoutCard.setClickable(true);
        linearLayoutCashDetail.setVisibility(View.VISIBLE);
        linearLayoutCardDetail.setVisibility(View.GONE);
        editTextValue.setText("");
        editTextValue.setHint(getResources().getString(R.string.cash));
    }

    public void selectCard(View view) {
        linearLayoutCash.setClickable(true);
        linearLayoutCard.setClickable(false);
        linearLayoutCashDetail.setVisibility(View.GONE);
        linearLayoutCardDetail.setVisibility(View.VISIBLE);
        editTextCvc.setText("");
        editTextCvc.setHint(getResources().getString(R.string.card_cvc));
        editTextNumber.setText("");
        editTextNumber.setHint(getResources().getString(R.string.card_number));
        editTextExpiredDate.setText("");
        editTextExpiredDate.setHint("mm/yyyy like 12/2017");
    }


    public void pay_with_cash(View view) {
        if (editTextValue.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please fill the box", Toast.LENGTH_SHORT).show();
            return;
        }
        int value = Integer.parseInt(editTextValue.getText().toString().trim());
        String message = payment.pay(new CashPayment(value));
        if (message.equals(StaticKeys.CASH_INSUFFICIENT)) {
            Toast.makeText(this, "Your money is not enough", Toast.LENGTH_SHORT).show();
        } else {
            order.setPaymentMessage(message);
            showSuccessDialog();
        }
    }

    public void pay_with_card(View view) {
        String cardnumber=editTextNumber.getText().toString().trim();
        String cardcvc=editTextCvc.getText().toString().trim();
        String cardexpireddate=editTextExpiredDate.getText().toString().trim();
        if (cardnumber.length() == 0 || cardexpireddate.length() >7 || editTextCvc.length() != 3) {
            Toast.makeText(this, "Please fill with valid format", Toast.LENGTH_SHORT).show();
            return;
        }
        String message = payment.pay(new CardPayment(cardnumber,cardcvc,cardexpireddate));
        switch (message){
            case StaticKeys.CARD_EXPIRED:
                Toast.makeText(this, "Card reach expired date", Toast.LENGTH_SHORT).show();
                break;
            case StaticKeys.CARD_INVALID:
                Toast.makeText(this, "Invalid card number", Toast.LENGTH_SHORT).show();
                break;
            case StaticKeys.CARD_WRONG_CVC:
                Toast.makeText(this, "Wrong card cvc code", Toast.LENGTH_SHORT).show();
                break;
            default:
                order.setPaymentMessage(message);
                showSuccessDialog();
                break;
        }
    }

    private void showSuccessDialog() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(PaymentActivity.this, StatusActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable(StaticKeys.ORDER, Parcels.wrap(Order.class, order));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        };
        mBuilder.setTitle("Payment success")
                .setMessage(order.getPaymentMessage())
                .setPositiveButton("OK", listener)
                .setCancelable(false);
        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }
}
