package no.shortcut.materialtest;

import android.content.Context;

import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import no.shortcut.materialtest.main.view.MainActivity;

/**
 * Created by Ivan on 11/04/16.
 */

@Module(
        library = true,
        injects = {
                MainActivity.class,
                Application.class
        }
)
public class ApplicationModule {

    private Application app;

    public ApplicationModule(Application app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return app;
    }

    @Provides
    @Singleton
    public Picasso providePicasso(Context context) {
        return Picasso.with(context);
    }
}


