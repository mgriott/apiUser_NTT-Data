package com.apiUser.apiUser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import sun.security.util.Length;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    /*@Id
    @GeneratedValue
    private UUID userId = UUID.randomUUID();*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String mail;
    private String pass;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @PrePersist
    private void onCreate() {
        lastUpdate = new Date();
    }


    //@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phoneId")
    private Phones phone;
}
