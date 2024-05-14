package com.ac.model;

import java.time.LocalDate;

public class StandardMembership extends Membership{


    public StandardMembership() {
        this.membershipType = MembershipType.STANDARD;
        this.annualRate = 100;
    }

    public StandardMembership(String membershipId,  LocalDate createdAt) {
        super(membershipId, createdAt);
        this.membershipType = MembershipType.STANDARD;
        this.annualRate = 100;
    }
}
