package group5.duan.library.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import group5.duan.library.enumration.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name= "idUser", columnDefinition = "CHAR(36)")
    @Type(type="uuid-char")
    private UUID userId;
    @Column(name="userName")
    private String userName;
    @Column(name="passWord")
    private String password;
    private String name;
    private String address;
    @Column(name="numberPhone")
    private String phone;
    @Column(name="birthdate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthDate;
    private boolean gender;
    @Column(name="url")
    private String avatarUrl;
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
