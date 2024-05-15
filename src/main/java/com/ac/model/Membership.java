package com.ac.model;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Represents a membership
 */
public abstract class Membership {


    /**
     * Enumerates the types of memberships
     */
    public enum MembershipType{
        STANDARD, PREMIUM, VIP
    }
    protected String membershipId;
    protected int annualRate;
    protected MembershipType membershipType;

    protected static int joiningFee = 8;
    protected LocalDate createdAt;

    public Membership() {
        this.membershipId = generateMembershipId();
        this.createdAt = LocalDate.now();
    }

    public Membership(String membershipId, LocalDate createdAt) {
        this.membershipId = membershipId;
        this.createdAt = createdAt;
    }
    //Methods
    /**
     * Generates a random membership Id
     * @return A string representing the membership Id
     */
    private String generateMembershipId(){
        //Generate a random UUID as the membership id
        UUID uuid = UUID.randomUUID();
        // Get the String representing the UUID
        String uuidString = uuid.toString();
        // Return the first 8 characters
        return uuidString.substring(0,8);
    }




    // Getters
    public String getMembershipId() {
        return membershipId;
    }

    public int getAnnualRate() {
        return annualRate;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public static int getJoiningFee() {
        return joiningFee;
    }

}
