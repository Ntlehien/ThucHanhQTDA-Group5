package group5.duan.library.dto.Book;

import lombok.Data;

import java.util.UUID;

@Data
public class BookBasicDto {
    private UUID bookId;
    private UUID userId;
    private String name;
    private String author;
    private Integer quantity;
}
