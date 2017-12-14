package com.kpl.sandwichshop.activities;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kpl.sandwichshop.Order;
import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;
import com.kpl.sandwichshop.observer.HistoryObserver;
import com.kpl.sandwichshop.observer.NotificationObserver;
import com.kpl.sandwichshop.observer.Observable;
import com.kpl.sandwichshop.observer.Observer;
import com.kpl.sandwichshop.observer.OrderObservable;

import org.parceler.Parcels;

public class StatusActivity extends AppCompatActivity {

    TextView textViewOrderInfo, textViewStatusInfo;
    Button buttonOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        Order order = Parcels.unwrap(getIntent().getParcelableExtra(StaticKeys.ORDER));
        Observer notificationObserver = new NotificationObserver(this);
        Observer historyObserver = new HistoryObserver();
        final Observable orderObservable = new OrderObservable(order);

//        textViewOrderInfo = findViewById(R.id.textview_order_info);
//        textViewOrderInfo.setText(order.toString());

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(StatusActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_status, null);
        textViewStatusInfo = (TextView) mView.findViewById(R.id.textview_status_info);
        buttonOk = (Button) mView.findViewById(R.id.button_ok);
        textViewStatusInfo.setText(order.toString());

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        orderObservable.register(notificationObserver);
        orderObservable.register(historyObserver);

        Thread observerTherad = new Thread() {
            public void run() {
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    orderObservable.notifyObserver();
                }

            }
        };
        observerTherad.start();

    }
}
