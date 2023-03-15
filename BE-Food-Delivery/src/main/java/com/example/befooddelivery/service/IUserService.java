package com.example.befooddelivery.service;

import com.example.befooddelivery.dto.CustomerDto;
import com.example.befooddelivery.dto.IdCustomerDto;
import com.example.befooddelivery.entity.Customer;
import org.springframework.data.repository.query.Param;

public interface IUserService {
    CustomerDto findCustomerByIdCustomer(Long idCustomer);
    IdCustomerDto findCustomerByIdAccount(Long idAccount);
}
