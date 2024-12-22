package train.springrestapi.bookerz.book.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import train.springrestapi.bookerz.book.exceptions.BookNotFoundException;
import train.springrestapi.bookerz.book.models.Book;
import train.springrestapi.bookerz.book.repository.IBookRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController implements IBookController{

    private final IBookRepository bookRepository;

    public BookController(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //CRUD's - Create, Read, Update, Delete
    @Override
    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    @Override
    public Optional<Book> getBookById(long id) {
        Optional<Book> bookById = bookRepository.getBookById(id);
        if(bookById.isPresent()) {
            return bookById;
        }else{
            throw new BookNotFoundException("Book not found");
        }
    }

    @Override
    public Book createBook(Book book) {
        return null;
    }

    @Override
    public Book updateBook(long id, Book book) {
        return null;
    }

    @Override
    public void deleteBook(long id) {

    }

}
