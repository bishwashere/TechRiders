package com.techriders.instorepickupservice.domains;

import javax.persistence.*;

@Entity
public class Follower {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne

    private User followedBy;
}

