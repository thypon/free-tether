package it.gtd.freetether;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import eu.chainfire.libsuperuser.Shell;
import it.gtd.freetether.ext.Activities;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.ExtensionMethod;

@ExtensionMethod(Activities.class)
public final class RootChecker extends Activity {
    @Getter(lazy = true, value = AccessLevel.PRIVATE) private final
    Button checkButton = this.findViewById(R.id.check_button);
    private static class CheckButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Shell.SU.available();
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.root_checker);
        getCheckButton().setOnClickListener(new CheckButtonListener());
    }
}