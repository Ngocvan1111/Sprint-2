package com.example.befooddelivery.repository.account;

import com.example.befooddelivery.entity.account.Role;
import com.example.befooddelivery.entity.account.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
