package com.ac.model;

import com.ac.helper.CSVFileOperations;

import java.io.File;
import java.io.IOException;

public class User {
    //
    private static int userNextId;

    static {
        try {
            userNextId = CSVFileOperations.getLastIdFromCSV(new File("users.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private String userId;
    private String username;
    private String password;

    public User(String username, String password) {
        if (userNextId>=0){
        this.userId = String.format("%07d", userNextId++);
        this.username = username;
        this.password = password;}
        else {
            this.userId = "0";
            this.username = username;
            this.password = password;
        }
    }

    public User(String userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }
    // Getters

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    //Setters

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    //Methods



    @Override
    public String toString() {
        return String.format("%s,%s,%s",userId,username,password);
    }
}
