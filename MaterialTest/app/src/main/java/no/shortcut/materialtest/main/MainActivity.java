package no.shortcut.materialtest.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.karumi.rosie.view.PresenterLifeCycleLinker;
import com.karumi.rosie.view.RosieAppCompatActivity;
import com.karumi.rosie.view.RosiePresenter;

public class MainActivity extends RosieAppCompatActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

}
