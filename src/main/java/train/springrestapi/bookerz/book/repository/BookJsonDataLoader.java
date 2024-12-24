package train.springrestapi.bookerz.book.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import train.springrestapi.bookerz.book.models.Book;
import train.springrestapi.bookerz.book.repository.IBookRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class BookJsonDataLoader implements CommandLineRunner {
    private final IBookRepository bookRepository;
    private final ObjectMapper objectMapper;

    public BookJsonDataLoader(ObjectMapper objectMapper, IBookRepository bookRepository) {
        this.objectMapper = objectMapper;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (bookRepository.count() == 0) {
            try (InputStream inputStream = getClass().getResourceAsStream("/data.json")) {
                if (inputStream == null) {
                    throw new IOException("File '/data.json' not found in resources.");
                }
                List<Book> books = objectMapper.readValue(inputStream, new TypeReference<>() {
                });
                bookRepository.saveAll(books);
                System.out.println("Books have been saved to the database.");
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }
        } else {
            System.out.println("Books are already loaded in the database.");
        }
    }

}
