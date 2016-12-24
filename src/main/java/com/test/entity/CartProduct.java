package com.test.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class CartProduct {
    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private long id;

    @ManyToOne
    private Product product;

    private boolean productBought;

    public CartProduct() {
    }
}
