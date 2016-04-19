package no.shortcut.materialtest.main.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import no.shortcut.materialtest.main.LastfmApplication;

/**
 * Created by Sijan Gurung on 15/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
    }

    private void injectDependencies() {
        LastfmApplication lastfmApplication = (LastfmApplication) getApplication();
        lastfmApplication.inject(this);
    }
}
