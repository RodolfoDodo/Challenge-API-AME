package factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Users;

import java.io.FileInputStream;
import java.io.IOException;

public class UsersDataFactory {

    public static Users deleteUsers() throws IOException{
        Users users = deleteUser();
        return users;
    }

    public static Users deleteUser() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Users users = objectMapper.readValue(new FileInputStream("src/test/resources/requestBody/deleteUsers.json"), Users.class);
        return users;
    }

    public static Users creatUsers() throws IOException {
        Users users = crateUser();
        return  users;
    }

    public static Users crateUser() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Users users = objectMapper.readValue(new FileInputStream("src/test/resources/requestBody/postCreate.json"), Users.class);
        return users;
    }



}
