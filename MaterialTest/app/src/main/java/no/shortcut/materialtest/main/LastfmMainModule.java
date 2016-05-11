package no.shortcut.materialtest.main;

import android.content.Context;
import android.view.LayoutInflater;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import no.shortcut.materialtest.main.ui.activity.MainActivity;
import no.shortcut.materialtest.main.ui.fragment.ArtistPlaylistFragment;
import no.shortcut.materialtest.main.ui.fragment.ArtistProfileFragment;
import no.shortcut.materialtest.main.ui.fragment.UserTopAlbumsFragment;

/**
 * Created by Sijan Gurung on 15/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
@Module(
        includes = {
        },
        injects = {
                LastfmApplication.class,
                MainActivity.class,
                ArtistPlaylistFragment.class,
                ArtistProfileFragment.class,
                UserTopAlbumsFragment.class
        },
        library = true
)
public class LastfmMainModule {

    private final Context context;

    public LastfmMainModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return context;
    }

    @Provides
    public LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(context);
    }
}
