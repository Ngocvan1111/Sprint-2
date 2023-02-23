package com.example.befooddelivery.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFood;
    private String name;
    private int quantity;
    private Double price;
    private Double comparePrice;
    private String description;
    private LocalDate createdDate = LocalDate.now();
    @ManyToOne()
    @JoinColumn(name = "order_id",referencedColumnName = "idOrders")
    private Orders order;
    @ManyToOne()
    @JoinColumn(name = "category_id", referencedColumnName = "idCategory")
    private Category category;
    @ManyToOne()
    @JoinColumn(name = "unit_id",referencedColumnName = "idUnit")
    private Unit unit;
    @OneToMany(mappedBy = "foodItem")
    private List<Image> imageList;
    @OneToOne(mappedBy = "foodItem")
    private Cart cart;

}
