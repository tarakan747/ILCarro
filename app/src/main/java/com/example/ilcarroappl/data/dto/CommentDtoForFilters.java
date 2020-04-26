package com.example.ilcarroappl.data.dto;

import com.google.gson.annotations.SerializedName;

public class CommentDtoForFilters {
    @SerializedName("first_name")
    String firstName;
    @SerializedName("photo")
    String photo;
    @SerializedName("post")
    String post;
    @SerializedName("post_date")
    String postDate;
    @SerializedName("second_name")
    String secondName;

    public CommentDtoForFilters() {
    }

    public CommentDtoForFilters(String firstName, String photo, String post, String postDate, String secondName) {
        this.firstName = firstName;
        this.photo = photo;
        this.post = post;
        this.postDate = postDate;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoto() {
        return photo;
    }

    public String getPost() {
        return post;
    }

    public String getPostDate() {
        return postDate;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "CommentDtoForFilters{" +
                "firstName='" + firstName + '\'' +
                ", photo='" + photo + '\'' +
                ", post='" + post + '\'' +
                ", postDate='" + postDate + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}


