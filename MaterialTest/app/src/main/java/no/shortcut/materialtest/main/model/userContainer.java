package no.shortcut.materialtest.main.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sijan Gurung on 13/04/16.
 * Shortcut AS
 * sijan.gurung@shortcut.no
 */
public class userContainer {
    @SerializedName("user")
    User user;

    public User getUser() {
        return user;
    }
}
