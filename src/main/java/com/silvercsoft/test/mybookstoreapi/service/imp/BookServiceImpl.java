package com.silvercsoft.test.mybookstoreapi.service.imp;

import com.silvercsoft.test.mybookstoreapi.dto.book.BookPage;
import com.silvercsoft.test.mybookstoreapi.dto.book.BookRequest;
import com.silvercsoft.test.mybookstoreapi.dto.book.BookResponse;
import com.silvercsoft.test.mybookstoreapi.exception.NotFoundException;
import com.silvercsoft.test.mybookstoreapi.mapper.BookMapper;
import com.silvercsoft.test.mybookstoreapi.model.Book;
import com.silvercsoft.test.mybookstoreapi.repository.BookRepository;
import com.silvercsoft.test.mybookstoreapi.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookPage getAllBooks(Pageable pageable) {
        return toBookReponsePage(bookRepository.findAll(pageable));
    }

    @Override
    public BookPage getBookByTitle(Pageable pageable, String title) {
        return toBookReponsePage(bookRepository.findBooksByTitle(pageable,title));
    }

    @Override
    @Transactional
    public BookResponse saveBook(BookRequest bookRequest) {
        Book book = bookMapper.bookRequestToBook(bookRequest);
        return bookMapper.bookToBookResponse(bookRepository.save(book));
    }

    @Override
    @Transactional
    public BookResponse updateBook(Long id, BookRequest bookRequest) {
        Optional<Book> book = bookRepository.findById(id);

        if(book.isEmpty()) {
            throw new NotFoundException("book with id " + id + " not found");
        }

        Book bookUpdated = bookMapper.bookRequestToBook(bookRequest);
        bookUpdated.setId(id);

        return bookMapper.bookToBookResponse(bookRepository.save(bookUpdated));
    }

    @Override
    @Transactional
    public void deleteBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);

        if(book.isEmpty()) {
            throw new NotFoundException("book with id " + id + " not found");
        }

        bookRepository.deleteById(id);
    }

    private BookPage toBookReponsePage(Page<Book> page) {
        return new BookPage(
                page.getContent().stream().map(bookMapper::bookToBookResponse).collect(Collectors.toList()),
                page.getTotalPages(),
                page.getNumber(),
                page.getTotalElements()
        );
    }
}
