package train.springrestapi.bookerz.book.models;
import jakarta.validation.constraints.NotEmpty;

public record Book(
        int Id,
        @NotEmpty
        String title,
        @NotEmpty
        String author,
        @NotEmpty
        String isbn
) {
}
