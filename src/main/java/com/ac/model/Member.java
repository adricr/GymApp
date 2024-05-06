package com.ac.model;

import com.ac.helper.CSVFileOperations;

import java.io.File;
import java.io.IOException;

/**
 * Represents a member of the Gym
 */
public class Member extends Person {
    private static int memberNextId;

    static {
        try {
            memberNextId = CSVFileOperations.getLastIdFromCSV(new File("members.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private final String memberId;
    private Membership membership;


    /**
     * Class Constructor
     * @param firstName The first name of the person
     * @param lastName The last name of the person
     * @param address The address of the person
     * @param city The city of the person
     * @param postcode The postcode of the person
     * @param membership The type of membership of the person
     */
    public Member(String firstName, String lastName, String address, String city, String postcode, Membership membership) {
        super(firstName, lastName, address, city, postcode);
        this.memberId = String.format("%07d", memberNextId++);
        this.membership = membership;
    }

    // Getters
    public String getMemberId() {
        return memberId;
    }

    public Membership getMembership() {
        return membership;
    }
    // Setters

    public void setMembership(Membership membership) {
        this.membership = membership;
    }
    //Methods


    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", memberId, membership.getMembershipId(), firstName, lastName, address, city, postcode, membership.getMembershipType(), membership.getAnnualRate(), membership.getCreatedAt() );
    }
}
