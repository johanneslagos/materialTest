package no.shortcut.materialtest.main.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import no.shortcut.materialtest.R;
import no.shortcut.materialtest.main.app.BaseFragment;

/**
 * Created by Sijan Gurung on 19/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
public class ArtistProfileFragment extends BaseFragment {
    public ArtistProfileFragment() {
    }
    public static Fragment newInstance(Context context){
        ArtistProfileFragment artistFragment = new ArtistProfileFragment();
        return artistFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.artist_profile,null);
        return root;
    }
}
