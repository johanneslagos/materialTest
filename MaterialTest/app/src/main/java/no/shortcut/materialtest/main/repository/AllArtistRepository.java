package no.shortcut.materialtest.main.repository;

import com.karumi.rosie.repository.RosieRepository;

import javax.inject.Inject;

import no.shortcut.materialtest.main.model.Artist;

/**
 * Created by Sijan Gurung on 11/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
public class AllArtistRepository extends RosieRepository<Long,Artist> {

    @Inject
    public AllArtistRepository(ArtistApiDataSource apiDataSource) {

        //data to api (only readable)
        addReadableDataSources(apiDataSource);
    }
}
