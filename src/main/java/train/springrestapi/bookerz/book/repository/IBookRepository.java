package train.springrestapi.bookerz.book.repository;

import org.springframework.data.repository.ListCrudRepository;
import train.springrestapi.bookerz.book.models.Book;

import java.util.List;
import java.util.Optional;

public interface IBookRepository extends ListCrudRepository<Book, Integer> {
    // get req -> get req from ListCrudRepository class

    @Override
    List<Book> findAll();

    @Override
    Optional<Book> findById(Integer integer);

    @Override
    <S extends Book> S save(S entity);

    @Override
    void deleteById(Integer integer);
//    void createBook(Book book);
//
//    void updateBook(long id, Book book);
//
//    void deleteBook(long id);
}
