package train.springrestapi.bookerz.book.models;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.Id;

public record Book(
        @Id
        Integer Id,
        @NotEmpty
        String title,
        @NotEmpty
        String author,
        @NotEmpty
        String isbn
) {
}
