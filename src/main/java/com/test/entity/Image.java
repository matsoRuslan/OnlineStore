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
public class Image {

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private long id;

    private String name;

    @Lob
    private byte[] image;

    public Image() {
    }
}
