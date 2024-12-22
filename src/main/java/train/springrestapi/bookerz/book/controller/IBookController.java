package train.springrestapi.bookerz.book.controller;

import train.springrestapi.bookerz.book.models.Book;

import java.util.List;
import java.util.Optional;

public interface IBookController {
    List<Book> getBooks();
    Optional<Book> getBookById(long id);
    void createBook(Book book);
    void updateBook(long id, Book book);
    void deleteBook(long id);
}
