package com.techriders.frontservice.domains;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class ShippingAddress {
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
    private String country;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private String zipCode;

    @ManyToOne
    @JoinColumn
    private User user;

    @NotBlank
    private String phoneNumber;

    private String extraInfo;

    @Transient
    private boolean sameBilling;

    @Transient
    private Boolean saveIntoFavouriteAddr;

    //to specify wheather user is using favourite address or not
    @Transient
    private Long addr_id = 0l;

    public ShippingAddress() {
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

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public boolean isSameBilling() {
        return sameBilling;
    }

    public void setSameBilling(boolean sameBilling) {
        this.sameBilling = sameBilling;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getAddr_id() {
        return addr_id;
    }

    public void setAddr_id(Long addr_id) {
        this.addr_id = addr_id;
    }

    public Boolean getSaveIntoFavouriteAddr() {
        return saveIntoFavouriteAddr;
    }

    public void setSaveIntoFavouriteAddr(Boolean saveIntoFavouriteAddr) {
        this.saveIntoFavouriteAddr = saveIntoFavouriteAddr;
    }
}
