package com.example.befooddelivery.service.account.impl;

import com.example.befooddelivery.entity.account.Role;
import com.example.befooddelivery.entity.account.RoleName;
import com.example.befooddelivery.repository.account.IRoleRepository;
import com.example.befooddelivery.service.account.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleService implements IRoleService {
    @Autowired
    IRoleRepository iRoleRepository;

    @Override
    public Optional<Role> findByName(RoleName name) {
        return iRoleRepository.findByName(name);
    }
}
