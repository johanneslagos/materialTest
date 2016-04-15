package no.shortcut.materialtest.main.model;

import no.shortcut.materialtest.main.repository.LastfmApiRepository;
import no.shortcut.materialtest.main.view.OnUserInteractorFinishedListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sijan Gurung on 13/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
public class UserInteractor implements Callback<userContainer> {

    //http://ws.audioscrobbler.com/2.0/?method=user.getinfo&user=johannesla&api_key=0e7cdecd43a80333bddb9eb6f0c488d4&format=json

    private OnUserInteractorFinishedListener listener;

    public UserInteractor(OnUserInteractorFinishedListener listener) {
        this.listener = listener;
    }



    public void loadUserInfo(String username) {
            LastfmApiRepository.ArtistApiClient client = LastfmApiRepository.create();
            Call<userContainer> call = client.listUserInfo("user.getinfo", username, "0e7cdecd43a80333bddb9eb6f0c488d4", "json");
            call.enqueue(this);
    }

    @Override
    public void onResponse(Call<userContainer> call, Response<userContainer> response) {
        listener.OnNetworkSuccess(response.body(), response);
    }

    @Override
    public void onFailure(Call<userContainer> call, Throwable t) {
        listener.OnNetworkFailure(t);
    }
}
