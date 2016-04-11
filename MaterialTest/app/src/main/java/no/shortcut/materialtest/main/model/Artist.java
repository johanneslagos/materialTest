package no.shortcut.materialtest.main.model;

import com.karumi.rosie.repository.datasource.Identifiable;

/**
 * Created by Sijan Gurung on 11/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
public class Artist implements Identifiable<Long> {
    @Override
    public Long getKey() {
        return null;
    }
}
