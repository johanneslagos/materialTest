package no.shortcut.materialtest.main.repository;

import com.karumi.rosie.repository.datasource.ReadableDataSource;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import no.shortcut.materialtest.main.model.Artist;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Sijan Gurung on 11/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
public class ArtistApiDataSource implements ReadableDataSource<Long, Artist> {

    @Inject
    public ArtistApiDataSource() {
    }

    @Override
    public Artist getByKey(Long key) throws Exception {
        return null;
    }

    @Override
    public Collection<Artist> getAll() throws Exception {

        AllArtistApiClient.ArtistApiClient client = AllArtistApiClient.create();

        Call<List<Artist>> call = client.getArtists("library.getartists"," 0e7cdecd43a80333bddb9eb6f0c488d4","johannesla","json");
        Response<List<Artist>> allartists = call.execute();
        List<Artist> artists = allartists.body();

        return artists;
    }
}
