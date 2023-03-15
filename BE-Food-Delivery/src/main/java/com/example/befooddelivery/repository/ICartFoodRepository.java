package com.example.befooddelivery.repository;

import com.example.befooddelivery.entity.CartFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ICartFoodRepository extends JpaRepository<CartFood, Long> {
    @Query (value = "select * from cart_food as cf where cf.id_food = :idFood and cf.id_cart = :idCart ",nativeQuery = true)
    CartFood findCartFoodByIdFoodAndIdCart(@Param("idFood") Long idFood,@Param("idCart") Long idCart);
    @Transactional
    @Modifying
    @Query(value = "update cart_food as cf set quantity = (quantity + :quantityIncrease) where cf.id_food = :idFood and cf.id_cart = :idCart and cf.flag_delete = false ", nativeQuery = true)
    void updateQuantityOfFoodIdCartFood(@Param("idFood") Long idFood,@Param("idCart") Long idCart, @Param("quantityIncrease") int quantityIncrease);
    @Transactional
    @Modifying
    @Query (value = "insert into cart_food values (:idCart,:idFood,:quantity, false, false )", nativeQuery = true)
    void createCartFood(@Param("idCart") Long idCart, @Param("idFood") Long idFood, @Param("quantity") int quantity);
    @Transactional
    @Modifying
    @Query (value = "update cart_food as cf set cf.quantity = :newQuantity where cf.id_food = :idFood and cf.id_cart = :idCart ", nativeQuery = true)
    void changeQuantityInCartFood(@Param("newQuantity") Long newQuantity, @Param("idFood") Long idFood, @Param("idCart") Long idCart);
    @Transactional
    @Modifying
    @Query (value = "update cart_food as cf set cf.flag_delete = true where cf.id_cart = :idCart and cf.id_food = :idFood and cf.flag_payment = false and cf.flag_delete = false ",nativeQuery = true)
    void deleteFoodInCart(@Param("idCart") Long idCart, @Param("idFood") Long idFood);
}
