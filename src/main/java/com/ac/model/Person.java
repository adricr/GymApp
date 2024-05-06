package com.ac.model;

/**
 * Represents a person
 */
public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected String address;
    protected String city;
    protected String postcode;

    /**
     *  Class Constructor
     * @param firstName The first name of the person
     * @param lastName The last name of the person
     * @param address The address of the person
     * @param city The city of the person
     * @param postcode The postcode of the person
     */
    public Person(String firstName, String lastName, String address, String city, String postcode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
    }
}
