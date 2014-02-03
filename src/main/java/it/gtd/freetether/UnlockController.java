package it.gtd.freetether;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import it.gtd.freetether.wifi.AccessPoint;
import it.gtd.freetether.wifi.Tether;

public final class UnlockController extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        switch (AccessPoint.of(context).getState()) {
            case Enabled:
                Tether.getInstance().unlock();
                break;
            case Disabled:
                Tether.getInstance().lock();
                break;
        }
    }
}
