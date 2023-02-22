package com.example.befooddelivery.entity;

import com.example.befooddelivery.entity.account.Account;
import lombok.*;

import javax.persistence.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdmin;
    private String name;
    private String email;
    private Integer phoneNumber;
    @OneToOne
    private Account account;
}
