package model;

import java.io.Serializable;

public class Customer implements Serializable {
    private int document;
    private String name;
    private String phoneNumber;

    public Customer() {}

    public Customer(int document, String name, String phoneNumber) {
        this.document = document;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getDocument() {
        return document;
    }

    public void setDocument(int document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return name;
    }
}
