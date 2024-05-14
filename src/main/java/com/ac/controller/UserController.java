package com.ac.controller;

import com.ac.helper.CSVFileOperations;
import com.ac.model.User;
import com.ac.view.index.Index;
import com.ac.view.user.Dashboard;

import java.io.*;
import java.util.ArrayList;

public class UserController {
    private final File userFile = new File("users.csv");
    /**
     * Constructor
     */
    public UserController() {
    }

    //Methods


    /**
     * Validates if username and password is in CSV
     * @param username The user to validate
     * @param password The password to validate
     * @return True if both user and password are matching
     */
    public boolean authenticateUser(String username,String password) {
        boolean isOk = false;
        ArrayList<User> userArrayList = new ArrayList<User>();
        try {
            userArrayList.addAll(getAllUsersFromCSV());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (User user : userArrayList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                isOk = true;
            }
        }
        return isOk;
    }

    /**
     * This method returns all the users from a csv file
     * @return ArrayList of type User
     * @throws IOException
     */
    public ArrayList<User> getAllUsersFromCSV() throws IOException {
        ArrayList<User> userArrayList = new ArrayList<User>();
        if (!userFile.exists()) {
            userArrayList.clear();
            return userArrayList;
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(userFile))){
            String line;
            //read all lines from the file
            while((line = reader.readLine()) != null){
                //split lines in strings
                String [] parts = line.split(",");
                //Create a new user with the parts of the string that represent the username and the password
                User user =new User(parts[0],parts[1],parts[2]);
                userArrayList.add(user);
            }
            return userArrayList; //return arraylist of users
        }catch (IOException e){
            e.printStackTrace();
            userArrayList.clear();
            return userArrayList;
        }

    }

    /**
     * This method returns the first instance found that uses the username provided
     * @param username String with the username to look for
     * @return the first user with this username
     * @throws RuntimeException when no user is found
     */
    public User getUserFromCSVByUsername(String username) throws RuntimeException{
        ArrayList<User> userArrayList = new ArrayList<User>();
        try {
            userArrayList.addAll(getAllUsersFromCSV());
            //for each user in userArrayList check if the username is the same
            for (User user : userArrayList) {
                if (user.getUsername().equals(username)) {
                    return user;
                }
            }
            throw new RuntimeException("No user Found");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method returns the first instance found that uses the Id provided
     * @param id String with the Id to look for
     * @return the first user with this username
     * @throws RuntimeException when no user is found
     */
    public User getUserFromCSVById(int id) throws RuntimeException{
        ArrayList<User> userArrayList = new ArrayList<User>();
        String idString = String.format("%07d",id);
        try {
            userArrayList.addAll(getAllUsersFromCSV());
            //for each user in userArrayList check if the username is the same
            for (User user : userArrayList) {
                if (user.getUserId().equals(idString)) {
                    return user;
                }
            }
            throw new RuntimeException("No user Found with Id ".concat(idString));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * This method saves an entered user to the users.csv file
     * @param user the user to enter
     */
    public void store(User user) throws IOException {
        if(user.getUserId().equals(String.format("%07d",-1))){
            user.setUserId(String.format("%07d",1));
            userFile.createNewFile();
        }
        try(PrintWriter writer = new PrintWriter(new FileWriter(userFile,true))){
            writer.println(user.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method saves all the users entered on an arraylist (Not checking that the ids are valid)
     * @param userArrayList Array List of type User
     */
    public void saveUsersToFile(ArrayList<User> userArrayList){
        userArrayList.forEach(user -> {
            try {
                store(user);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
