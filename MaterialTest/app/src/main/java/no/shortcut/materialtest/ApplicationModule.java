package no.shortcut.materialtest;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ivan on 11/04/16.
 */

@Module(
        injects = {
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
}

