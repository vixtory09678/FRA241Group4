package com.example.fragment.dao;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Palmkongkiet on 11/28/2016.
 */

public class PromoteDao {
    @SerializedName("url_picture")
    private String urlPicture;

    @SerializedName("url_link")
    private String urlLink;

    @SerializedName("content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrlPicture() {
        return urlPicture;
    }

    public void setUrlPicture(String urlPicture) {
        this.urlPicture = urlPicture;
    }

    public String getUrlLink() {
        return urlLink;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }
}
