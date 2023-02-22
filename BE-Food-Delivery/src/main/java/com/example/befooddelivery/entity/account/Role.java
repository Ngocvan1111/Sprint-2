package com.example.befooddelivery.entity.account;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRole;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private com.example.befooddelivery.entity.account.RoleName name;

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public com.example.befooddelivery.entity.account.RoleName getName() {
        return name;
    }

    public void setName(com.example.befooddelivery.entity.account.RoleName name) {
        this.name = name;
    }
}
