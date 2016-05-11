package no.shortcut.materialtest.main.presenter;

import no.shortcut.materialtest.main.model.Album.TopAlbumsWrapper;
import no.shortcut.materialtest.main.model.Album.AlbumInteractor;
import no.shortcut.materialtest.main.ui.view.IAlbumView;
import retrofit2.Response;

/**
 * Created by Waqas Moazzam on 10/05/16.
 * Shortcut AS
 * waqas.moazzam@shortcut.no
 */
public class AlbumPresenter implements IAlbumPresenter, AlbumInteractor.AlbumInteractorNetworkListener{

    private IAlbumView view;
    private AlbumInteractor interactor;

    public AlbumPresenter(IAlbumView view) {
        this.view = view;
        this.interactor = new AlbumInteractor(this);
    }

    @Override
    public void loadUserTopAlbums(String username) {
        interactor.loadUserTopAlbums(username);
    }

    @Override
    public void OnNetworkSuccess(TopAlbumsWrapper topAlbums, Response response) {
        view.onUserTopAlbumsSuccess(topAlbums,response);
    }

    @Override
    public void OnNetworkFailure(Throwable error) {
        view.onUserTopAlbumsFailure(error);
    }
}
