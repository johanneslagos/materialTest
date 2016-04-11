package no.shortcut.materialtest;

import com.karumi.rosie.application.RosieApplication;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ivan on 11/04/16.
 */
public class Application extends RosieApplication {

    @Override protected List<Object> getApplicationModules() {
        return Arrays.asList((Object) new ApplicationModule(this));
    }

}
