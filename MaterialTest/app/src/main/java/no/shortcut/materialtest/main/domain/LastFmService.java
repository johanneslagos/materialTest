package no.shortcut.materialtest.main.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import no.shortcut.materialtest.main.model.userContainer;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Sijan Gurung on 13/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
public interface LastFmService {
    @GET("?")
    Call<userContainer> listUserInfo(@Query("method") String method,
                                     @Query("user") String user,
                                     @Query("api_key") String api_key,
                                     @Query("format") String format);
}