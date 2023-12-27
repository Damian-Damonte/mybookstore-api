package com.silvercsoft.test.mybookstoreapi.dto.book;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record BookResponse(
        Long id,
        String title,
        String author,
        String genre,
        Integer quantity,
        BigDecimal price,
        @JsonProperty("image_url")
        String imageUrl
) {}
