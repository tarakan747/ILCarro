package com.example.ilcarroappl.dtoHUINI;

public class UserBaseDto {
    String first_name, photo, second_name;

    @Override
    public String toString() {
        return "UserBaseDto{" +
                "first_name='" + first_name + '\'' +
                ", photo='" + photo + '\'' +
                ", second_name='" + second_name + '\'' +
                '}';
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getPhoto() {
        return photo;
    }

    public String getSecond_name() {
        return second_name;
    }

    public UserBaseDto() {
    }

    public UserBaseDto(String first_name, String photo, String second_name) {
        this.first_name = first_name;
        this.photo = photo;
        this.second_name = second_name;
    }
}
