package com.kpl.sandwichshop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.kpl.sandwichshop.Order;
import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;
import com.kpl.sandwichshop.builder.Sandwich;
import com.kpl.sandwichshop.observer.HistoryObserver;
import com.kpl.sandwichshop.observer.NotificationObserver;
import com.kpl.sandwichshop.observer.Observable;
import com.kpl.sandwichshop.observer.Observer;
import com.kpl.sandwichshop.observer.OrderObservable;

public class StatusActivity extends AppCompatActivity {

    TextView textViewOrderInfo;
    Sandwich sandwich = new Sandwich();
    int notificationId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        Order order = (Order) getIntent().getExtras().getSerializable(StaticKeys.ORDER);

        Observer notificationObserver = new NotificationObserver(this);
        Observer historyObserver = new HistoryObserver();
        final Observable orderObservable = new OrderObservable(order);

        textViewOrderInfo = findViewById(R.id.textview_order_info);
        textViewOrderInfo.setText(order.toString());

        orderObservable.register(notificationObserver);
        orderObservable.register(historyObserver);

        Thread observerTherad = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    orderObservable.notifyObserver();
                }

            }
        };
        observerTherad.start();

    }
}
