package no.shortcut.materialtest;

import android.content.Context;

import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import no.shortcut.materialtest.main.repository.AllArtistApiClient;

import static java.util.concurrent.TimeUnit.MINUTES;

/**
 * Created by Ivan on 11/04/16.
 */

@Module(library = true,
        complete = false,
        injects = {
                Application.class
        })
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(final Application application) {
        this.application = application;
    }

    @Provides
    public Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    public Picasso providePicasso(Context context) {
        return Picasso.with(context);
    }

    @Provides
    @Singleton
    public AllArtistApiClient.ArtistApiClient provideApiClient() {
        return AllArtistApiClient.create();
    }
}