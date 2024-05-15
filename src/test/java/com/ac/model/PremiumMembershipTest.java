package com.ac.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PremiumMembershipTest {
    private PremiumMembership premiumMembership;
    @BeforeEach
    void setUp() {
        premiumMembership = new PremiumMembership("1", LocalDate.now());
    }

    @Test
    void getMembershipId() {
        assertEquals(premiumMembership.getMembershipId(),"1");

    }

    @Test
    void getAnnualRate() {
        assertEquals(premiumMembership.getAnnualRate(),150);
    }

    @Test
    void getMembershipType() {
        assertEquals(premiumMembership.getMembershipType(), Membership.MembershipType.PREMIUM);
    }

    @Test
    void getCreatedAt() {
        assertEquals(premiumMembership.getCreatedAt(),LocalDate.now());
    }

    @Test
    void getJoiningFee() {
        assertEquals(premiumMembership.getJoiningFee(),8);
    }

}