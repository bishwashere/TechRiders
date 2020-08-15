package com.warehouseService.rabbitmq.domains;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class BillingAddress {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String addressL1;

    private String addressL2;

    @NotBlank
    @Size(max = 50)
    private String country;

    @NotBlank
    @Size(max = 50)
    private String city;

    @NotBlank
    @Size(max = 2)
    private String state;

    @NotBlank
    @Size(min = 2,max = 8)
    private String zipCode;

    @NotBlank
    @Size(max = 20, min = 8)
    private String phoneNumber;

    @ManyToOne
    @JoinColumn
    private User user;

    public BillingAddress() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddressL1() {
        return addressL1;
    }

    public void setAddressL1(String addressL1) {
        this.addressL1 = addressL1;
    }

    public String getAddressL2() {
        return addressL2;
    }

    public void setAddressL2(String addressL2) {
        this.addressL2 = addressL2;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
