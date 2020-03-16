package com.example.ilcarroappl.dto;

public class PersonWhoBookedDto {
    String email, first_name, phone, second_name;

    public PersonWhoBookedDto() {
    }

    public PersonWhoBookedDto(String email, String first_name, String phone, String second_name) {
        this.email = email;
        this.first_name = first_name;
        this.phone = phone;
        this.second_name = second_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    @Override
    public String toString() {
        return "PersonWhoBookedDto{" +
                "email='" + email + '\'' +
                ", first_name='" + first_name + '\'' +
                ", phone='" + phone + '\'' +
                ", second_name='" + second_name + '\'' +
                '}';
    }
}
