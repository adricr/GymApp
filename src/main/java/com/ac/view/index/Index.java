package com.ac.view.index;

import com.ac.controller.GuiController;
import com.ac.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Index {
    private JPanel indexMain;
    private JButton logInButton;
    private JButton registerButton;
    private JPanel credentialPanel;

    ArrayList<User> userArrayList = new ArrayList<User>();
    GuiController guiController = new GuiController();
    public static void main(JFrame frame){

        //userController.saveUserToFile(new User("mamawe","potato"));
        //System.out.println(userController.getUserFromCSVByUsername("mamawe").toString());
        //System.out.println(userController.getUserFromCSVById(5).toString());
        //System.out.println(userController.authenticateUser("senior", "potato"));
        //Membership membership = new Membership(156, Membership.MembershipType.STANDARD); MIRA ESTO QUE ES PROBLEMATICO
        //JFrame frame = new JFrame("GymApp");
        frame.setContentPane(new Index().indexMain);
        frame.setVisible(true);

    }

    public Index() {
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiController.fireLogin();
                
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiController.fireRegister();
            }
        });
    }
}
