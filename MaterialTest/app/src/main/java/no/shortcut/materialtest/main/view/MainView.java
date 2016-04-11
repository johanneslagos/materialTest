package no.shortcut.materialtest.main.view;

import com.karumi.rosie.view.RosiePresenter;

import java.util.Collection;

import no.shortcut.materialtest.main.model.Artist;

/**
 * Created by Sijan Gurung on 11/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
public interface MainView extends RosiePresenter.View {
    void showArtists(final Collection<Artist> repositories);
    void showError(Error error);
}
