package no.shortcut.materialtest.main.presenter;

import com.karumi.rosie.domain.usecase.UseCaseHandler;
import com.karumi.rosie.domain.usecase.annotation.Success;
import com.karumi.rosie.domain.usecase.callback.OnSuccessCallback;
import com.karumi.rosie.view.RosiePresenter;

import java.util.Collection;

import javax.inject.Inject;

import no.shortcut.materialtest.main.domain.GetArtists;
import no.shortcut.materialtest.main.model.Artist;
import no.shortcut.materialtest.main.view.MainView;

/**
 * Created by Sijan Gurung on 11/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
public class MainPresenter extends RosiePresenter<MainView>{
    private final GetArtists getArtists;

    @Inject
    public MainPresenter(final UseCaseHandler useCaseHandler, final GetArtists getArtists) {
        super(useCaseHandler);
        this.getArtists = getArtists;
    }

    private void showArtists(final Collection<Artist> artists) {
        getView().showArtists(artists);
    }

    private void loadPeople() {
        createUseCaseCall(getArtists)
                .onSuccess(new OnSuccessCallback() {
                    @Success
                    public void onRepositoriesLoaded(Collection<Artist> artists) {
                        showArtists(artists);
                    }
                })
                .execute();
    }
}
