package no.shortcut.materialtest.main.ui.view;

import no.shortcut.materialtest.main.model.Album.TopAlbumsWrapper;
import retrofit2.Response;

/**
 * Created by waqas on 10/05/16.
 * Shortcut AS
 */
public interface IAlbumView {
    void onUserTopAlbumsSuccess(TopAlbumsWrapper topAlbums, Response response);
    void onUserTopAlbumsFailure(Throwable error);
}
