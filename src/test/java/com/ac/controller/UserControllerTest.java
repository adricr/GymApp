package com.ac.controller;

import com.ac.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    User user;
    UserController userController;
    @BeforeEach
    void setUp() {
        user = new User("user","pass");
        userController = new UserController();
        try {
            userController.store(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void authenticateUser() {
        assertTrue(userController.authenticateUser("user","pass"));
    }


    @Test
    void authenticateUserWrongUser() {
        assertFalse(userController.authenticateUser("1651","pass"));
    }

    @Test
    void authenticateUserWrongPass() {
        assertFalse(userController.authenticateUser("user","!!!!!!!!!!"));
    }



}