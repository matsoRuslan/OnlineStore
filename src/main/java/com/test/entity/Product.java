package com.test.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Product {

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private long id;

    private String title;

    private String description;

    @Lob
    private String fullDescription;

    @Column(precision = 19, scale = 2)
    private BigDecimal price;

    private Integer amount;

    private boolean active;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Image image;

    public Product() {
    }
}
