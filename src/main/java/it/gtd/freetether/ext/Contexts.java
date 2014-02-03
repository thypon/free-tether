package it.gtd.freetether.ext;

import android.content.Context;

public final class Contexts {
    public static <T extends Object> T getSystemService(Context context, String id) {
        return (T)context.getSystemService(id);
    }
}
