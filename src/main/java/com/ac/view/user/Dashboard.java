package com.ac.view.user;

import com.ac.controller.GuiController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard {

    private JButton addANewMemberButton;
    private JPanel panel1;
    private JButton displayMemberReceiptButton;
    private JButton displayMembersButton;
    private JButton exitButton;

    GuiController guiController = new GuiController();
    public Dashboard() {
        addANewMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            guiController.fireAddNewMember();
            }
        });
        displayMembersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            guiController.fireDisplayMembers();
            }
        });
        displayMemberReceiptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            guiController.fireDisplayMemberReceipt();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            System.exit(0);
            }
        });
    }

    public static void main(JFrame frame) {
        frame.setContentPane(new Dashboard().panel1);
        frame.setVisible(true);
    }
}
