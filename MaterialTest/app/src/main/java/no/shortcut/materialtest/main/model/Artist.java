package no.shortcut.materialtest.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sijan Gurung on 11/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */

public class Artist {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("mbid")
    @Expose
    private String mbid;
    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("image") @Expose private List<ImageInfo> images;

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

}