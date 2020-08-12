package com.techriders.logisticservice.domains;


import com.techriders.logisticservice.annotations.EmailUnique;
import com.techriders.logisticservice.annotations.UserNameUnique;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 4,max = 50)
    private String firstName;

    @NotBlank
    @Size(min = 4,max = 50)
    private String lastName;

    @NotBlank
    @Size(min = 4,max = 50)
    @UserNameUnique
    private String userName;

    @NotBlank
    private String password;


    @NotBlank
    @Email
    @EmailUnique
    private String email;

    private Short adminVerification = 0;

    private Short userStatus = 0;

    private Long points = 0l;

    @ManyToMany
    @JoinTable
    private List<UserRole> userRoles;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ShippingAddress> shippingAddress;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Payment> payment;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BillingAddress> billingAddress;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Short getAdminVerification() {
        return adminVerification;
    }

    public void setAdminVerification(Short adminVerification) {
        this.adminVerification = adminVerification;
    }

    public Short getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Short userStatus) {
        this.userStatus = userStatus;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public List<ShippingAddress> getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(List<ShippingAddress> shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<Payment> getPayment() {
        return payment;
    }

    public void setPayment(List<Payment> payment) {
        this.payment = payment;
    }

    public List<BillingAddress> getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(List<BillingAddress> billingAddress) {
        this.billingAddress = billingAddress;
    }
}
