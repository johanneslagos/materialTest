package no.shortcut.materialtest.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.karumi.rosie.view.PresenterLifeCycleLinker;
import com.karumi.rosie.view.RosieAppCompatActivity;
import com.karumi.rosie.view.RosiePresenter;

public class MainActivity extends RosieAppCompatActivity implements RosiePresenter.View {

        private PresenterLifeCycleLinker presenterLifeCycleLinker = new PresenterLifeCycleLinker();

        @Override protected void onCreate(Bundle savedInstanceState) {
            presenterLifeCycleLinker.initializeLifeCycle(this, this);
            super.onCreate(savedInstanceState);
        }
        @Override protected void onResume() {
            presenterLifeCycleLinker.updatePresenters(this);
            super.onResume();
        }

        @Override protected void onPause() {
            presenterLifeCycleLinker.pausePresenters();
            super.onPause();
        }

        @Override protected void onDestroy() {
            super.onDestroy();
        }

    @Override
    protected int getLayoutId() {
        return 0;
    }

}
