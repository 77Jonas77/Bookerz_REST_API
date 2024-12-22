package train.springrestapi.bookerz.book.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import train.springrestapi.bookerz.book.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryMokeDb implements IBookRepository {

    private List<Book> books = new ArrayList<>();

    @PostConstruct // after init of bean properties
    private void init(){
        books.add(new Book(1, "Book 1", "Author 1", "Genre 1"));
        books.add(new Book(2, "Book 2", "Author 2", "Genre 2"));
        books.add(new Book(3, "Book 3", "Author 3", "Genre 3"));
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Optional<Book> getBookById(long id) {
        return Optional.empty();
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
