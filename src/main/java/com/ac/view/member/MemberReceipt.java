package com.ac.view.member;

import com.ac.controller.GuiController;
import com.ac.model.Member;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberReceipt {
    private JButton displayMembersButton;
    GuiController guiController = new GuiController();
    private JTextField memberId;
    private JButton goBackButton;
    private JPanel MemberReceipt;
    private JPanel footer;
    private JPanel textEntry;
    private JButton searchButton;

    private JDialog dialog;
    public MemberReceipt() {
        displayMembersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiController.fireDisplayMembers();
            }
        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiController.fireDashboard();
            }
        });


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = memberId.getText();
                guiController.fireReceipt(guiController.retrieveMember(Integer.parseInt(id)));

            }
        });
    }

    public static void main(JFrame frame) {
        frame.setContentPane(new MemberReceipt().MemberReceipt);
        frame.setVisible(true);
    }
}
