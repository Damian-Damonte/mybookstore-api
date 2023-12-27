package com.silvercsoft.test.mybookstoreapi.service;

import com.silvercsoft.test.mybookstoreapi.dto.book.BookPage;
import com.silvercsoft.test.mybookstoreapi.dto.book.BookRequest;
import com.silvercsoft.test.mybookstoreapi.dto.book.BookResponse;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookPage getAllBooks(Pageable pageable);
    BookPage getBookByTitle(Pageable pageable, String title);
    BookResponse saveBook(BookRequest bookRequest);
    BookResponse updateBook(Long id, BookRequest bookRequest);
    void deleteBook(Long id);
}
