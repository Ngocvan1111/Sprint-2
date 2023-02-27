package com.example.befooddelivery.service.account;

import com.example.befooddelivery.entity.account.Role;
import com.example.befooddelivery.entity.account.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
