package com.example.ilcarroappl.dto;

public class CommentsDto {
    String first_name;
    String photo;
    String post;
    String post_date;
    String second_name;

    @Override
    public String toString() {
        return "CommentsDto{" +
                "first_name='" + first_name + '\'' +
                ", photo='" + photo + '\'' +
                ", post='" + post + '\'' +
                ", post_date='" + post_date + '\'' +
                ", second_name='" + second_name + '\'' +
                '}';
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getPhoto() {
        return photo;
    }

    public String getPost() {
        return post;
    }

    public String getPost_date() {
        return post_date;
    }

    public String getSecond_name() {
        return second_name;
    }

    public CommentsDto(String first_name, String photo, String post, String post_date, String second_name) {
        this.first_name = first_name;
        this.photo = photo;
        this.post = post;
        this.post_date = post_date;
        this.second_name = second_name;
    }

    public CommentsDto() {
    }
}
