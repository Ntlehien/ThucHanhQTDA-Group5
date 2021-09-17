package group5.duan.library.dto.Book;

import lombok.Data;

@Data
public class BookCreateDto {
    private String name;
    private String author;
    private Integer quantity;
}
