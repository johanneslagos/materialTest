package no.shortcut.materialtest.main.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import no.shortcut.materialtest.main.domain.LastFmService;
import no.shortcut.materialtest.main.domain.TagsTypeAdapterFactory;
import no.shortcut.materialtest.main.view.OnUserInteractorFinishedListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

    public Retrofit useRetrofit(){
        String URL_STR = "http://ws.audioscrobbler.com/2.0/?method=user.getinfo&user=johannesla&api_key=0e7cdecd43a80333bddb9eb6f0c488d4&format=json/";
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new TagsTypeAdapterFactory()) // This is the important line ;)
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_STR)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }

    public void loadUserInfo(String username) {
            Retrofit client = useRetrofit();
            LastFmService service = client.create(LastFmService.class);
            Call<userContainer> call = service.listUserInfo("user.getinfo", "johannesla", "0e7cdecd43a80333bddb9eb6f0c488d4", "json");
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
