package it.gtd.freetether.ext;

import android.app.Activity;
import android.view.View;

public final class Activities {
    public static <T extends View> T findViewById(Activity activity, int id) {
        return (T)activity.findViewById(id);
    }
}
