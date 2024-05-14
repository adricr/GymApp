package com.ac.controller;

import com.ac.model.*;
import com.ac.view.index.Index;
import com.ac.view.member.*;
import com.ac.view.user.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class GuiController {
    static private JFrame frame = new JFrame("GymApp");
    static private UserController userController = new UserController();
    static private MemberController memberController = new MemberController();


    public static void main(String[] args) throws IOException {
        frame.setSize(800 ,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GuiController guiController = new GuiController();
        guiController.fireIndex();

    }
    //Frame Callers
    public void fireDashboard(){
        Dashboard.main(frame);
    }

    public void fireAddNewMember() {
        Create.main(frame);
    }

    public void fireIndex() {
        Index.main(frame);
    }

    public void fireLogin() {
        Login.main(frame);
    }
    public void fireDisplayMembers() {
        ArrayList<Member> memberArrayList =new ArrayList<Member>();
        try {
            memberArrayList.addAll(memberController.getAllMembersFromCSV());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DisplayMembers.main(frame);
    }

    public void fireDisplayMemberReceipt() {
        MemberReceipt.main(frame);
    }

    public void fireReceipt(Member member) {
        Receipt.main(frame,member);
    }

    public void fireRegister(){
        Register.main(frame);
    }

    public void logIn(String username, String password){
        if (userController.authenticateUser(username,password)){
            fireDashboard();
        }
    }
    public void register(String username,String password){
        User user = new User(username,password);
        try {
            userController.store(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fireIndex();
    }

    public void displayMembers(){

    }


    public void displayMemberReceipt() {
    }

    public void createMember(JTextField firstNameText, JTextField lastNameText, JTextField addressText, JTextField cityText, JTextField postcodeText, Membership.MembershipType membershipType) {
    switch (membershipType){
        case STANDARD:
            try {
                memberController.store(new Member(firstNameText.getText(),lastNameText.getText(), addressText.getText(), cityText.getText(), postcodeText.getText(), new StandardMembership()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            break;
        case PREMIUM:
            try {
                memberController.store(new Member(firstNameText.getText(),lastNameText.getText(), addressText.getText(), cityText.getText(), postcodeText.getText(), new PremiumMembership()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            break;
        case VIP:
            try {
                memberController.store(new Member(firstNameText.getText(),lastNameText.getText(), addressText.getText(), cityText.getText(), postcodeText.getText(), new VIPMembership()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            break;
    }
    }

    public ArrayList<Member> retrieveMembers(){
        try {
            return memberController.getAllMembersFromCSV();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param id Id of the member to retrieve
     * @return Member with the id entered
     */
    public Member retrieveMember(int id){
        return memberController.getMemberFromCSVById(id);

    }



}
