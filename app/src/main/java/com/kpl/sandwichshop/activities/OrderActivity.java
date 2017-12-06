package com.kpl.sandwichshop.activities;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onOrderClicked(View view) {
        sandwich.register(order);
        sendNotification(order.update());
    }

    public void onUpdateClicked(View view) {
        sandwich.setReady(true);
        sendNotification(order.update());
    }

    private void sendNotification(String message) {
        NotificationCompat.Builder builder =
                (NotificationCompat.Builder)
                        new NotificationCompat.Builder(this)
                                .setSmallIcon(R.drawable.ic_notification)
                                .setContentTitle("Sandwich Shop")
                                .setContentText(message);
        NotificationManager manager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        manager.notify(notificationId, builder.build());

        notificationId += 1;
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
