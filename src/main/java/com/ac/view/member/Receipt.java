package com.ac.view.member;

import com.ac.controller.GuiController;
import com.ac.model.Member;
import com.ac.model.Membership;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Receipt {
    private JTextArea receipt;
    private JPanel panel1;
    private JButton goBackButton;

    GuiController guiController = new GuiController();
    public Receipt() {
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiController.fireDashboard();
            }
        });
    }

    public static void main(JFrame frame, Member member) {
        Receipt receipt = new Receipt();
        String template;
        int joiningFee = 8;
        Membership membership = member.getMembership();
        template =
                "Statement for "+String.format("%d",membership.getCreatedAt().getYear())+" for "+member.getFirstName()+" "+member.getLastName()+" - New "+membership.getMembershipType()+" Membership\n"+
                "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"+
                "      "+membership.getMembershipType()+" Member Enrolment\n"+
                "      "+"  "+"Date: "+membership.getCreatedAt().toString()+"\n"+
                "      "+"  "+"Purchases:\n"+
                "      "+"  "+"  "+"1:  Annual Membership: "+"£"+String.format("%d",membership.getAnnualRate())+".00"+"\n"+
                "      "+"  "+"  "+"2:  Joining Fee:       "+"£"+String.format("%d",joiningFee)+"\n\n"+
                "      "+"Total Price: "+"£"+String.format("%d",joiningFee+membership.getAnnualRate())+".00\n"+
                "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
        ;
        receipt.receipt.append(template);
        frame.setContentPane(receipt.panel1);
        frame.setVisible(true);
    }
}
