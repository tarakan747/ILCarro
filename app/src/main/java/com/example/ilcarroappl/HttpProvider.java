package com.example.ilcarroappl;


import com.example.ilcarroappl.dto.UserDto;
import java.io.IOException;


public interface HttpProvider {
    UserDto registration(String email, String password, String firstName, String lastName) throws IOException;
}
