package com.example.befooddelivery.repository;

import com.example.befooddelivery.dto.CustomerDto;
import com.example.befooddelivery.dto.IdCustomerDto;
import com.example.befooddelivery.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends JpaRepository<Customer, Long> {
    @Query (value = "select c.name as name, c.email as email, c.phone_number as phoneNumber, c.address as address from customer as c where c.id_customer = :idCustomer",nativeQuery = true)
    CustomerDto findCustomerByIdCustomer(Long idCustomer);
    @Query (value = "select c.id_customer as idCustomer from customer as c join account a on c.account_id_account = a.id_account join cart c2 on c.id_customer = c2.customer_id where a.id_account = :idAccount group by c2.customer_id",nativeQuery = true)
    IdCustomerDto findCustomerByIdAccount(@Param("idAccount") Long idAccount);
}
