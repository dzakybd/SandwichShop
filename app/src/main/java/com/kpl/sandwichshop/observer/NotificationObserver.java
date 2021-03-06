package com.kpl.sandwichshop.observer;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;

import com.kpl.sandwichshop.Order;
import com.kpl.sandwichshop.R;

/**
 * Created by Hendry on 12/5/2017.
 */

public class NotificationObserver implements Observer {

    private Context context;
    private int notificationId;

    public NotificationObserver(Context context) {
        this.context = context;
    }

    @Override
    public void update(Order order) {
        NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(context, "M_CH_ID")
                                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setContentTitle("Sandwich ready")
                                .setAutoCancel(true)
                                .setContentText(order.toString())
                                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                                .setStyle(new NotificationCompat.BigTextStyle().bigText(order.toString()));
        NotificationManager manager = (NotificationManager)
                context.getSystemService(context.NOTIFICATION_SERVICE);
        if (manager != null) {
            manager.notify(notificationId, builder.build());
        }
        notificationId += 1;
    }
}
