package com.ac.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StandardMembershipTest {
    private StandardMembership standardMembership;

    @BeforeEach
    void setUp() {
        standardMembership = new StandardMembership();
    }


    @Test
    void getAnnualRate() {
        assertEquals(standardMembership.getAnnualRate(),100);
    }

    @Test
    void getMembershipType() {
        assertEquals(standardMembership.getMembershipType(), Membership.MembershipType.STANDARD);
    }

    @Test
    void getCreatedAt() {
        assertEquals(standardMembership.getCreatedAt(), LocalDate.now());
    }

    @Test
    void getJoiningFee() {
        assertEquals(standardMembership.getJoiningFee(),8);
    }

}