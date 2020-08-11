package com.techriders.frontservice.domains;

import com.techriders.frontservice.configs.RoleEnum;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Authority implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 12)
    private String authority;

    @ManyToOne
    @JoinColumn(name = "user_name", referencedColumnName = "userName")
    private User user;

    public Authority() {
    }
    public Authority(User user, RoleEnum authority) {
        this.user = user;

        if(authority.equals(RoleEnum.ROLE_ADMIN)){
            this.authority = "ROLE_ADMIN";
        }else if(authority.equals(RoleEnum.ROLE_SELLER)){

            this.authority = "ROLE_SELLER";
        }else{

            this.authority = "ROLE_BUYER";
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String toString(){
        return authority;
    }
}
