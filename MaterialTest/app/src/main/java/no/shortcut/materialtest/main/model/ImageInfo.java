package no.shortcut.materialtest.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sijan Gurung on 19/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
public class ImageInfo {
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
