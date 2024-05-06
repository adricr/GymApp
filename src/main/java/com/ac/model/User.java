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
        this.userId = String.format("%07d", userNextId++);
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

    //Methods

    /**
     * Validates if username and password is matching
     * @param username The user to validate
     * @param password The password to validate
     * @return True if both user and password are matching
     */
    public boolean authenticate(String username,String password){
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s",userId,username,password);
    }
}
