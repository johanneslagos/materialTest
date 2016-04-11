package no.shortcut.materialtest.main.domain;

import com.karumi.rosie.domain.usecase.RosieUseCase;
import com.karumi.rosie.domain.usecase.annotation.UseCase;

import java.util.Collection;

import javax.inject.Inject;

import no.shortcut.materialtest.main.model.Artist;
import no.shortcut.materialtest.main.repository.AllArtistRepository;

/**
 * Created by Sijan Gurung on 11/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
public class GetArtists extends RosieUseCase {
    private final AllArtistRepository allArtistsRepo;

    @Inject
    public GetArtists(final AllArtistRepository allArtistsRepo) {
        this.allArtistsRepo = allArtistsRepo;
    }

    @UseCase
    public void getArtists() throws Exception {
        Collection<Artist> repositories = allArtistsRepo.getAll();
        notifySuccess(repositories);
    }
}
