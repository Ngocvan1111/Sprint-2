package com.example.befooddelivery.entity;
import com.example.befooddelivery.entity.account.Account;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCustomer;
    private String name;
    private String email;
    private Integer phoneNumber;
    private String address;
    @OneToOne
    private Account account;
    @OneToMany(mappedBy = "customer")
    private List<Orders> orderList;
    @OneToOne(mappedBy = "customer")
    private Cart cart;

}
