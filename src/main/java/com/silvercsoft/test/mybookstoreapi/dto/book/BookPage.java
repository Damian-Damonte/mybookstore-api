package com.silvercsoft.test.mybookstoreapi.dto.book;

import java.util.List;

public record BookPage(
        List<BookResponse> data,
        int totalPages,
        int currentPage,
        Long totalElements
) {
}
