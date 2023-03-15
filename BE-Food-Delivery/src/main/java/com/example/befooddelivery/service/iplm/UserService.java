package com.example.befooddelivery.service.iplm;

import com.example.befooddelivery.dto.CustomerDto;
import com.example.befooddelivery.dto.IdCustomerDto;
import com.example.befooddelivery.entity.Customer;
import com.example.befooddelivery.repository.IUserRepository;
import com.example.befooddelivery.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;
    @Override
    public CustomerDto findCustomerByIdCustomer(Long idCustomer) {
        return userRepository.findCustomerByIdCustomer(idCustomer);
    }

    @Override
    public IdCustomerDto findCustomerByIdAccount(Long idAccount) {
        return userRepository.findCustomerByIdAccount(idAccount);
    }
}
