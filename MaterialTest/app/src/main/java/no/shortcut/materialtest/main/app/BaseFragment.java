package no.shortcut.materialtest.main.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import butterknife.ButterKnife;
import no.shortcut.materialtest.main.LastfmApplication;

/**
 * Created by Sijan Gurung on 19/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        injectViews(view);
    }

    private void injectDependencies() {
        LastfmApplication lastfmApplication = (LastfmApplication) getActivity().getApplication();
        lastfmApplication.inject(this);
    }

    private void injectViews(View view) {
        ButterKnife.bind(this, view);
    }
}
