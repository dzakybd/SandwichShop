package com.kpl.sandwichshop.observer;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import com.kpl.sandwichshop.Order;
import com.kpl.sandwichshop.R;

/**
 * Created by Hendry on 12/5/2017.
 */

public class NotificationObserver implements Observer {

    Context context;
    int notificationId;

    public NotificationObserver(Context context) {
        this.context = context;
    }

    @Override
    public void update(Order order) {
        NotificationCompat.Builder builder =
                (NotificationCompat.Builder)
                        new NotificationCompat.Builder(context)
                                .setSmallIcon(R.drawable.ic_notification)
                                .setContentTitle("Sandwich Shop")
                                .setContentText(order.toString());
        NotificationManager manager = (NotificationManager)
                context.getSystemService(context.NOTIFICATION_SERVICE);
        manager.notify(notificationId, builder.build());

        notificationId += 1;
    }
}
