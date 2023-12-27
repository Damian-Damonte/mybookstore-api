package com.silvercsoft.test.mybookstoreapi.mapper;

import com.silvercsoft.test.mybookstoreapi.dto.book.BookRequest;
import com.silvercsoft.test.mybookstoreapi.dto.book.BookResponse;
import com.silvercsoft.test.mybookstoreapi.model.Book;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface BookMapper {
    Book bookRequestToBook(BookRequest bookRequest);
    BookResponse bookToBookResponse(Book book);
}
