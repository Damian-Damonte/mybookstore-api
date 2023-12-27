package com.silvercsoft.test.mybookstoreapi.dto.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record BookRequest(
        @NotBlank(message = "title is required")
        @Size(max = 200, message = "title cannot be longer than 200 characters")
        String title,
        @NotBlank(message = "author is required")
        @Size(max = 200, message = "author cannot be longer than 200 characters")
        String author,
        @NotBlank(message = "genre is required")
        @Size(max = 200, message = "genre cannot be longer than 200 characters")
        String genre,
        @NotNull(message = "the quantity is required")
        @Min(value = 0, message = "the quantity must be greater than 0")
        Integer quantity,
        @DecimalMin(value = "0.00",  message = "the price must be greater than 0.00")
        @NotNull(message = "price is required")
        BigDecimal price,
        @JsonProperty("image_url")
        @Size(max = 500, message = "image url cannot be longer than 500 characters")
        String imageUrl
) {}
