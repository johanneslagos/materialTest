package no.shortcut.materialtest.main.model.Album;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import no.shortcut.materialtest.main.model.Artist;
import no.shortcut.materialtest.main.model.ImageInfo;

/**
 * Created by Waqas Moazzam on 10/05/16.
 * Shortcut AS
 * waqas.moazzam@shortcut.no
 */

public class Album {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("mbid")
    @Expose
    private String mbid;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("playcount")
    @Expose
    private String playCount;

    @SerializedName("artist")
    @Expose
    private Artist artist;

    @SerializedName("image")
    @Expose
    private List<ImageInfo> images;

    /**
     *
     * @return
     * The name
     */
    public List<ImageInfo> getImages(){return images;}

    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The mbid
     */
    public String getMbid() {
        return mbid;
    }

    /**
     *
     * @param mbid
     * The mbid
     */
    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }


    public String getPlayCount() {
        return playCount;
    }

    public Artist getArtist() {
        return artist;
    }

}