package com.ac.view.member;

import com.ac.controller.GuiController;
import com.ac.model.Membership;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Create {
    private JButton createMemberButton;
    private JPanel panel1;
    private JTextField firstNameText;
    private JTextField lastNameText;
    private JTextField addressText;
    private JTextField cityText;
    private JTextField postcodeText;
    private JRadioButton standardRadioButton;
    private JRadioButton VIPRadioButton;
    private JRadioButton premiumRadioButton;
    private JButton goBackButton;

    GuiController guiController = new GuiController();

    public Create() {
        createMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if (standardRadioButton.isSelected()){
                guiController.createMember(firstNameText,lastNameText,addressText,cityText,postcodeText, Membership.MembershipType.STANDARD);
            }else if (VIPRadioButton.isSelected()){
                guiController.createMember(firstNameText,lastNameText,addressText,cityText,postcodeText, Membership.MembershipType.VIP);
            } else if (premiumRadioButton.isSelected()) {
                guiController.createMember(firstNameText,lastNameText,addressText,cityText,postcodeText, Membership.MembershipType.PREMIUM);
            }else if (!standardRadioButton.isSelected() && !VIPRadioButton.isSelected() && !premiumRadioButton.isSelected()){
                System.out.println("problem!");
            }
            guiController.fireDisplayMembers();
            }
        });


        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiController.fireDashboard();
            }
        });
    }

    public static void main(JFrame frame) {
        frame.setContentPane(new Create().panel1);
        frame.setVisible(true);
    }
}
