package train.springrestapi.bookerz.book.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import train.springrestapi.bookerz.book.exceptions.BookNotFoundException;
import train.springrestapi.bookerz.book.models.Book;
import train.springrestapi.bookerz.book.repository.IBookRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController implements IBookController{

    //BL in Controller and Repository due to simplicity of this project
    private final IBookRepository bookRepository;

    public BookController(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //CRUD's - Create, Read, Update, Delete
    @Override
    @GetMapping
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable int id) {
        Optional<Book> bookById = bookRepository.findById(id);
        if(bookById.isPresent()) {
            return bookById;
        }else{
            throw new BookNotFoundException("Book not found");
        }
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook(@Valid @RequestBody Book book) {
        bookRepository.save(book);
    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateBook(@PathVariable int id, @Valid @RequestBody Book book) {
        bookRepository.save(book);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id) {
        bookRepository.deleteById(id);
    }

}
