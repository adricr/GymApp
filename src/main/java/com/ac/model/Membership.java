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
    protected LocalDate createdAt;

    public Membership(int annualRate, MembershipType membershipType) {
        this.membershipId = generateMembershipId();
        this.annualRate = annualRate;
        this.membershipType = membershipType;
        this.createdAt = LocalDate.now();
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

    //Setters

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    public void setAnnualRate(int annualRate) {
        this.annualRate = annualRate;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }
}
