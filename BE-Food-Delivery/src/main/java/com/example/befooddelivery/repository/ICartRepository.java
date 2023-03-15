package com.example.befooddelivery.repository;

import com.example.befooddelivery.dto.CartDto;
import com.example.befooddelivery.dto.CartPaymentDto;
import com.example.befooddelivery.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICartRepository extends JpaRepository<Cart, Long> {
    /**
     * funtion Find all food in cart
     * @param idCustomer
     * @return the food list in cart
     */
    @Query (value = "SELECT i.url AS url, " +
            "f.name AS foodName, " +
            "f.id_food AS idFood, " +
            "f.price AS price, " +
            "cf.quantity AS quantity " +
            "FROM cart AS c " +
            "JOIN cart_food cf ON c.id_cart = cf.id_cart " +
            "JOIN food f ON cf.id_food = f.id_food " +
            "JOIN image i ON f.id_food = i.food_id " +
            "WHERE c.customer_id = :idCustomer and c.flag_payment = false and cf.flag_delete = false \n" +
            "GROUP BY i.food_id", nativeQuery = true)
    List<CartDto> findAllFoodInCart(@Param("idCustomer") Long idCustomer);

    /**
     * funtion Update quantity of food in cart
     * @param idCart
     */
    @Transactional
    @Modifying
    @Query(value = "update cart as c set c.quantity = (select sum(cf.quantity) as quantity from cart_food as cf where  cf.id_cart = :idCart and cf.flag_delete = false group by cf.id_cart) where c.id_cart = :idCart", nativeQuery = true)
    void updateQuantityOfFoodInCart( @Param("idCart") Long idCart);
    @Query(value = "select c.* from cart as c  where c.customer_id =:idCustomer and c.flag_payment = false group by c.customer_id",nativeQuery = true)
    Cart findCartByCustomerId(@Param("idCustomer") Long idCustomer);
    /**
     * funtion total money need to pay
     * @param idCart
     */
    @Query (value = "select sum(cf.quantity*f.price/22000) as totalPayUSD, sum(cf.quantity*f.price) as totalPayVND from cart_food as cf join food f on cf.id_food = f.id_food  where cf.id_cart = :idCart group by cf.id_cart", nativeQuery = true)
    CartPaymentDto getTotalPay(@Param("idCart") Long idCart);
    /**
     * funtion total money need to pay
     * @param idCart
     */
    @Transactional
    @Modifying
    @Query (value = "update sprint_2.cart as c set c.flag_payment = true where c.id_cart = :idCart", nativeQuery = true)
    void removeCartAfterPayment(@Param("idCart") Long idCart);

}
