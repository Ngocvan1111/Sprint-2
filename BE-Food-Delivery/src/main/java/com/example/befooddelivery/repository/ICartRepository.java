package com.example.befooddelivery.repository;

import com.example.befooddelivery.dto.CartDto;
import com.example.befooddelivery.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICartRepository extends JpaRepository<Cart, Long> {
    @Query (value = "SELECT i.url AS url, " +
            "f.name AS foodName, " +
            "f.price AS price, " +
            "cf.quantity AS quantity " +
            "FROM cart AS c " +
            "JOIN cart_food cf ON c.id_cart = cf.id_cart " +
            "JOIN food f ON cf.id_food = f.id_food " +
            "JOIN image i ON f.id_food = i.food_id " +
            "WHERE c.customer_id = :idCustomer " +
            "GROUP BY i.food_id", nativeQuery = true)
    List<CartDto> findAllFoodInCart(@Param("idCustomer") Long idCustomer);
}
