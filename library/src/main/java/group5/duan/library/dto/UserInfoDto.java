package group5.duan.library.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserInfoDto {
    private UUID userId;
    private String name;
    private String address;
    private String phone;
    private String token;
}
