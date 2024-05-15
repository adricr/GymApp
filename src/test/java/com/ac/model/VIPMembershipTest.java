package com.ac.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VIPMembershipTest {
    private static VIPMembership vipMembership;

    @BeforeEach
    void setUp() {
        vipMembership = new VIPMembership("1", LocalDate.now());
    }
    @Test
    void getMembershipId() {
        assertEquals(vipMembership.getMembershipId(),"1");

    }

    @Test
    void getAnnualRate() {
        assertEquals(vipMembership.getAnnualRate(),200);
    }

    @Test
    void getMembershipType() {
        assertEquals(vipMembership.getMembershipType(), Membership.MembershipType.VIP);
    }

    @Test
    void getCreatedAt() {
        assertEquals(vipMembership.getCreatedAt(),LocalDate.now());
    }

    @Test
    void getJoiningFee() {
        assertEquals(vipMembership.getJoiningFee(),8);
    }


}