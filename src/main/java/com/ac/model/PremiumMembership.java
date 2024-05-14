package com.ac.model;

import java.time.LocalDate;

public class PremiumMembership extends Membership{
    public PremiumMembership() {
        this.membershipType = MembershipType.PREMIUM;
        this.annualRate = 150;
    }

    public PremiumMembership(String membershipId, LocalDate createdAt) {
        super(membershipId, createdAt);
        this.membershipType = MembershipType.PREMIUM;
        this.annualRate = 150;
    }
}
