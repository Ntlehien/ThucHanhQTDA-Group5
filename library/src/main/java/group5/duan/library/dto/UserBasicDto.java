package group5.duan.library.dto;

import group5.duan.library.enumration.UserRole;
import lombok.Data;

import java.util.Date;
@Data
public class UserBasicDto {
    private String userName;
    private String password;
    private String name;
    private String address;
    private String phone;
    private Date birthDate;
    private boolean gender;
    private String avatarUrl;
    private UserRole role;
}
