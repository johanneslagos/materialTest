package no.shortcut.materialtest.main.model.Album;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Waqas Moazzam on 10/05/16.
 * Shortcut AS
 * waqas.moazzam@shortcut.no
 */
public class TopAlbumsWrapper {
    @SerializedName("topalbums")
    @Expose
    AlbumsWrapper albums;

    public AlbumsWrapper getAlbums() {
        return albums;
    }
}
