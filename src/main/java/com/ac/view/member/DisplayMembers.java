package com.ac.view.member;
import com.ac.controller.GuiController;
import com.ac.model.Member;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DisplayMembers {

    private JPanel panel1;
    private JTextArea textArea1;
    private JButton goBackButton;

    ArrayList <Member> memberArrayList;
    GuiController guiController = new GuiController();

    public DisplayMembers() {
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiController.fireDashboard();
            }
        });
    }



    public static void main(JFrame frame) {
        DisplayMembers displayMembers = new DisplayMembers();
        displayMembers.guiController = new GuiController();
        displayMembers.memberArrayList = new ArrayList<Member>();
        String members = "ID      MembID      Name    SecondName    Address          Postcode    MemType    AnnualFee    Created at \n";
        String endLine = "\n";
        displayMembers.memberArrayList.addAll(displayMembers.guiController.retrieveMembers());
        for (Member member : displayMembers.memberArrayList) {
            members = members.concat(member.toString()+endLine);
        }
        displayMembers.textArea1.append(members);
        frame.setContentPane(displayMembers.panel1);
        frame.setVisible(true);
    }


}
