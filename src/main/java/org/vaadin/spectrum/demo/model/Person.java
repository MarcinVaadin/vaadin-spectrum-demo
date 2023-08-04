package org.vaadin.spectrum.demo.model;

public class Person {

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        System.out.println("Firstname: " + firstName);
        this.firstName = firstName;
    }
}
