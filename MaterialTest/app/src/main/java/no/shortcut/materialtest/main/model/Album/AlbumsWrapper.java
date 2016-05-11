package no.shortcut.materialtest.main.model.Album;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Waqas Moazzam on 10/05/16.
 * Shortcut AS
 * waqas.moazzam@shortcut.no
 */
public class AlbumsWrapper {
    @SerializedName("album")
    @Expose
    List<Album> albums;

    public List<Album> getUserTopAlbums() {
        return albums;
    }
}
