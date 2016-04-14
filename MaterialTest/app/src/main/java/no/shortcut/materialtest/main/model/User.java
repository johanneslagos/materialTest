package no.shortcut.materialtest.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sijan Gurung on 13/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
public class User {

    @SerializedName("name") @Expose private String name;

    @SerializedName("image") @Expose private List<ImageInfo> images;

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("subscriber")
    @Expose
    private String subscriber;
    @SerializedName("playcount")
    @Expose
    private String playcount;
    @SerializedName("playlists")
    @Expose
    private String playlists;
    @SerializedName("bootstrap")
    @Expose
    private String bootstrap;
    @SerializedName("type")
    @Expose
    private String type;

    public static class ImageInfo {
        @SerializedName("#text") @Expose
        String imageUrl;
        @SerializedName("size") @Expose
        String size;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }
    }

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

    /**
     *
     * @return
     * The country
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     * The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     * The age
     */
    public String getAge() {
        return age;
    }

    /**
     *
     * @param age
     * The age
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     *
     * @return
     * The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     * The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     * The subscriber
     */
    public String getSubscriber() {
        return subscriber;
    }

    /**
     *
     * @param subscriber
     * The subscriber
     */
    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }

    /**
     *
     * @return
     * The playcount
     */
    public String getPlaycount() {
        return playcount;
    }

    /**
     *
     * @param playcount
     * The playcount
     */
    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    /**
     *
     * @return
     * The playlists
     */
    public String getPlaylists() {
        return playlists;
    }

    /**
     *
     * @param playlists
     * The playlists
     */
    public void setPlaylists(String playlists) {
        this.playlists = playlists;
    }

    /**
     *
     * @return
     * The bootstrap
     */
    public String getBootstrap() {
        return bootstrap;
    }

    /**
     *
     * @param bootstrap
     * The bootstrap
     */
    public void setBootstrap(String bootstrap) {
        this.bootstrap = bootstrap;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", country='" + country + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", subscriber='" + subscriber + '\'' +
                ", playcount='" + playcount + '\'' +
                ", playlists='" + playlists + '\'' +
                ", bootstrap='" + bootstrap + '\'' +
                ", type='" + type + '\'' +
                '}';
    }


}