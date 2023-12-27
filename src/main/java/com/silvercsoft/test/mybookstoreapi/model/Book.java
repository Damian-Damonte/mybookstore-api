package com.silvercsoft.test.mybookstoreapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "Book")
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;
    @Column(nullable = false, length = 200)
    private String title;
    @Column(nullable = false, length = 200)
    private String author;
    @Column(nullable = false, length = 200)
    private String genre;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false, precision = 20, scale = 2)
    private BigDecimal price;
    @Column(length = 500)
    private String imageUrl;
}
