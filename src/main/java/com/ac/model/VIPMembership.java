package com.ac.model;

import java.time.LocalDate;

public class VIPMembership extends Membership{
    public VIPMembership() {
        this.membershipType = MembershipType.VIP;
        this.annualRate = 200;
    }

    public VIPMembership(String membershipId, LocalDate createdAt) {
        super(membershipId, createdAt);
        this.membershipType = MembershipType.VIP;
        this.annualRate = 200;
    }
}
