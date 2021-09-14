package group5.duan.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name= "idBook", columnDefinition = "CHAR(36)")
    @Type(type="uuid-char")
    private UUID bookId;
    @Column(name="idUser")
    @Type(type="uuid-char")
    private UUID userId;
    @Column(name="idFile")
    @Type(type="uuid-char")
    private UUID fileId;
    private String name;
    private String author;
    private Integer quantity;
}
