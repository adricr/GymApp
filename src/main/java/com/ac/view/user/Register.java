package com.ac.view.user;

import com.ac.controller.GuiController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register {
    GuiController guiController = new GuiController();
    private JPanel panel1;
    private JTextField username;
    private JTextField password;
    private JPanel info;
    private JPanel header;
    private JButton goBackButton;
    private JButton registerButton;

    public Register() {
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiController.fireIndex();
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiController.register(username.getText(),password.getText());
            }
        });
    }

    public static void main(JFrame frame) {
        frame.setContentPane(new Register().panel1);
        frame.setVisible(true);
    }
}
