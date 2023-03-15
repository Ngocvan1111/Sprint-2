package com.example.befooddelivery.controller.user;

import com.example.befooddelivery.dto.CustomerDto;
import com.example.befooddelivery.entity.Customer;
import com.example.befooddelivery.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/user")
public class RestUserController {
    @Autowired
    IUserService userService;
    @GetMapping("{idCustomer}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("idCustomer") Long idCustomer){
        CustomerDto customerDto = userService.findCustomerByIdCustomer(idCustomer);
        if(customerDto == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(customerDto, HttpStatus.OK);
        }
    }

}
