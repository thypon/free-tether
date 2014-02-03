package it.gtd.freetether.wifi;

import android.content.Context;
import android.net.wifi.WifiManager;
import it.gtd.freetether.ext.Contexts;
import lombok.*;
import lombok.experimental.ExtensionMethod;
import lombok.extern.apachecommons.CommonsLog;

@Value(staticConstructor = "of")
@CommonsLog
@ExtensionMethod(Contexts.class)
public final class AccessPoint {
    Context context;

    @Getter(lazy = true, value = AccessLevel.PRIVATE) private final
    WifiManager wifiManager = context.getSystemService(Context.WIFI_SERVICE);

    public State getState() {
        try {
            int state = (Integer)getWifiManager().getClass().getMethod("getWifiApState").invoke(getWifiManager());

            switch (state) {
                case 0:
                case 10:
                    return State.Disabling;
                case 1:
                case 11:
                    return State.Disabled;
                case 2:
                case 12:
                    return State.Enabling;
                case 3:
                case 13:
                    return State.Enabled;
                case 4:
                case 14:
                    return State.Failed;
                default:
                    log.error("Return value not invalid");
            }
        } catch (Exception e) {
            log.error(e);
        }

        return State.Unknown;
    }
}
