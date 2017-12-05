package com.kpl.sandwichshop.activities;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.builder.Sandwich;
import com.kpl.sandwichshop.observer.Observer;
import com.kpl.sandwichshop.observer.Order;

public class OrderActivity extends AppCompatActivity {

    Sandwich sandwich = new Sandwich();
    Observer order = new Order(sandwich);
    int notificationId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onOrderClicked(View view) {
    // Subscribe to notifications
        sandwich.register(order);
        sendNotification(order.update());
    }

    public void onUpdateClicked(View view) {
    // Mimic message from server
        sandwich.setReady(true);
        sendNotification(order.update());
    }

    private void sendNotification(String message) {
        NotificationCompat.Builder builder =
                (NotificationCompat.Builder)
                        new NotificationCompat.Builder(this)
                                .setSmallIcon(R.drawable.ic_launcher_round)
                                .setContentTitle("Sandwich Factory")
                                .setContentText(message);
        NotificationManager manager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        manager.notify(notificationId, builder.build());
    // Update notifications if needed
        notificationId += 1;
    }

}
