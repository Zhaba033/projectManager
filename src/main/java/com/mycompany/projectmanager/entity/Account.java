package com.mycompany.projectmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")

@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @SequenceGenerator(
            name = "account_seq",
            sequenceName = "account_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    Long id;

    @Column(nullable = false)
    String username;
    @Column(nullable = false)
    String password;
}
