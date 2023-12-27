package com.silvercsoft.test.mybookstoreapi.controller;

import com.silvercsoft.test.mybookstoreapi.dto.book.BookPage;
import com.silvercsoft.test.mybookstoreapi.dto.book.BookRequest;
import com.silvercsoft.test.mybookstoreapi.dto.book.BookResponse;
import com.silvercsoft.test.mybookstoreapi.service.BookService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<BookPage> getAllBook(@PageableDefault(page = 0, size = 10, sort = "price") Pageable pageable) {
        return ResponseEntity.ok(bookService.getAllBooks(pageable));
    }

    @GetMapping("/search")
    public ResponseEntity<BookPage> searchBooksByTitle(@PageableDefault(page = 0, size = 10, sort = "price") Pageable pageable,
                                                                 @RequestParam String title) {
        return ResponseEntity.ok(bookService.getBookByTitle(pageable, title));
    }

    @PostMapping
    public ResponseEntity<BookResponse> saveBook(@RequestBody @Valid BookRequest bookRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(bookRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable Long id, @RequestBody @Valid BookRequest bookRequest) {
        return ResponseEntity.ok(bookService.updateBook(id, bookRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
