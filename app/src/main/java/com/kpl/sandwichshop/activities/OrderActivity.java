package com.kpl.sandwichshop.activities;

import android.support.v7.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

//    Sandwich sandwich = new Sandwich();
//    Observer order = new NotificationObserver(sandwich);
//    int notificationId = 1;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_order);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//    }
//
//    public void onOrderClicked(View view) {
//        sandwich.register(order);
//        sendNotification(order.update());
//    }
//
//    public void onUpdateClicked(View view) {
//        sandwich.setReady(true);
//        sendNotification(order.update());
//    }
//
//    private void sendNotification(String message) {
//        NotificationCompat.Builder builder =
//                (NotificationCompat.Builder)
//                        new NotificationCompat.Builder(this)
//                                .setSmallIcon(R.drawable.ic_notification)
//                                .setContentTitle("Sandwich Shop")
//                                .setContentText(message);
//        NotificationManager manager = (NotificationManager)
//                getSystemService(NOTIFICATION_SERVICE);
//        manager.notify(notificationId, builder.build());
//
//        notificationId += 1;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                onBackPressed();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//    @Override
//    public void onBackPressed() {
//        finish();
//        super.onBackPressed();
//    }
}
