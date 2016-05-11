package no.shortcut.materialtest.main.model.Album;

import no.shortcut.materialtest.main.repository.LastfmApiRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sijan Gurung on 13/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
public class AlbumInteractor implements Callback<TopAlbumsWrapper> {

    //http://ws.audioscrobbler.com/2.0/?method=user.getinfo&user=johannesla&api_key=0e7cdecd43a80333bddb9eb6f0c488d4&format=json

    private AlbumInteractorNetworkListener listener;

    public AlbumInteractor(AlbumInteractorNetworkListener listener) {
        this.listener = listener;
    }

    public void loadUserTopAlbums(String username) {
            LastfmApiRepository.ArtistApiClient client = LastfmApiRepository.create();
            Call<TopAlbumsWrapper> call = client.getUserTopAlbums("user.gettopalbums", username, "0e7cdecd43a80333bddb9eb6f0c488d4", "json");
            call.enqueue(this);
    }

    @Override
    public void onResponse(Call<TopAlbumsWrapper> call, Response<TopAlbumsWrapper> response) {
        listener.OnNetworkSuccess(response.body(), response);
    }

    @Override
    public void onFailure(Call<TopAlbumsWrapper> call, Throwable t) {
        listener.OnNetworkFailure(t);
    }

    public interface AlbumInteractorNetworkListener {
        void OnNetworkSuccess(TopAlbumsWrapper topAlbums, Response response);
        void OnNetworkFailure(Throwable error);
    }
}
