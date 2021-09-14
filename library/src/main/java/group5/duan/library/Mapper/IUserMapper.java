package group5.duan.library.Mapper;

import group5.duan.library.dto.UserBasicDto;
import group5.duan.library.dto.UserCreateDto;
import group5.duan.library.dto.UserInfoDto;
import group5.duan.library.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    UserEntity fromCreateToEntity(UserCreateDto user);
    UserBasicDto toBasicDto(UserEntity returnUser);
    List<UserBasicDto> toBasicDtos(List<UserEntity> users);

    UserEntity fromBasicToEntity(UserBasicDto user);

    UserInfoDto toInfoDto(UserEntity userEntity);
}
