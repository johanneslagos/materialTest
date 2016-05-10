package no.shortcut.materialtest.main;

import android.app.Application;
import android.content.Context;

import dagger.ObjectGraph;

/**
 * Created by Sijan Gurung on 15/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
public class LastfmApplication extends Application {
    private ObjectGraph objectGraph;

    /**
     * Static method for get application context
     *
     * @param context
     * @return
     */
    public static LastfmApplication get(Context context) {
        return (LastfmApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(new LastfmMainModule(this));
        objectGraph.inject(this);
    }

    public void inject(Object object) {
        objectGraph.inject(object);
    }

    /**
     * Add a new module to the dependency graph
     *
     * @param modules
     */
    public void addModules(Object... modules) {
        objectGraph.plus(modules);
    }
}
