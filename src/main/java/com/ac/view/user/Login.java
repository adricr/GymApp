package com.ac.view.user;

import com.ac.controller.GuiController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JLabel Login;
    private JTextField userText;
    private JTextField passwordText;
    private JButton goBackButton;
    private JButton logInButton;
    private JPanel view;

    GuiController guiController = new GuiController();
    public Login() {
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiController.fireIndex();
            }
        });
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiController.logIn(userText.getText(),passwordText.getText());
            }
        });
    }
    public static void main(JFrame frame) {
        frame.setContentPane(new Login().view);
        frame.setVisible(true);
    }
}
