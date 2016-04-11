package no.shortcut.materialtest.main.repository;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import no.shortcut.materialtest.main.model.Artist;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Sijan Gurung on 11/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
//http://ws.audioscrobbler.com/2.0/?method=library.getartists&api_key= 0e7cdecd43a80333bddb9eb6f0c488d4&user=johannesla&format=json

public class AllArtistApiClient {
    private static final String API_URL = "http://ws.audioscrobbler.com/2.0/";

    public interface ArtistApiClient {
        @GET("/artist/")
        Call<List<Artist>> getArtists(@Query("method") String method, @Query("api_key") String API_Key, @Query("user") String user, @Query("format") String format );

        @GET("/artistProfile")
        Call<Artist> getArtistProfile(@Query("method") String method, @Query("api_key") String API_Key, @Query("artist") String user, @Query("format") String format );
    }

    public static ArtistApiClient create() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(ArtistApiClient.class);
    }
}
