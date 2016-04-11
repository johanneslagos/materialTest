package no.shortcut.materialtest.main.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.karumi.rosie.view.PresenterLifeCycleLinker;
import com.karumi.rosie.view.RosieAppCompatActivity;
import com.karumi.rosie.view.RosiePresenter;

import no.shortcut.materialtest.R;

public class MainActivity extends RosieAppCompatActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

}
