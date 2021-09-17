package group5.duan.library.Service.user;

import group5.duan.library.Mapper.IUserMapper;
import group5.duan.library.dto.AuthenticationRequestDto;
import group5.duan.library.dto.UserBasicDto;
import group5.duan.library.dto.UserCreateDto;
import group5.duan.library.dto.UserInfoDto;
import group5.duan.library.dto.UserLoginDto;
import group5.duan.library.entity.UserEntity;
import group5.duan.library.repository.UserRepository;
import group5.duan.library.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class UserService  implements IUserService {
    private final UserRepository userRepo;
    @Autowired
    private JwtUtil jwtTokenUtil;

    private final IUserMapper userMapper;

    public UserService(UserRepository userRepo, IUserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }
    @Override
    public UserInfoDto login(AuthenticationRequestDto authenticationRequestDto) {
        UserEntity userEntity = userRepo.findFirstByUserNameAndPassword(authenticationRequestDto.getUsername(),
                authenticationRequestDto.getPassword());
        if (userEntity != null) {
            UserDetails userDetails = this.loadUserByUsername(authenticationRequestDto.getUsername());
            final String token = jwtTokenUtil.generateToken(userDetails);

            UserInfoDto userInfoDto = userMapper.toInfoDto(userEntity);
            userInfoDto.setToken(token);
            return userInfoDto;
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String userName)  {
        Optional<UserEntity> user = userRepo.findByUserName(userName);
        return user.map(UserLoginDto::new).get();
    }
    public UserBasicDto createUser(UserCreateDto user){
        UserEntity userEntity = userMapper.fromCreateToEntity(user);
        userEntity.setPassword(Base64.getEncoder().encodeToString((user.getUserName() + ":" + user.getPassword()).getBytes()));
        UserEntity returnUser = userRepo.save(userEntity);
        return userMapper.toBasicDto(returnUser);
    }
    public UserBasicDto getById(UUID UserId){
        UserEntity userEntity = userRepo.findFirstByUserId(UserId);
        if(userEntity != null) {
            return userMapper.toBasicDto(userEntity);
        }
        return null;
    }

    public boolean delete(UUID UserId){
        UserEntity userEntity = userRepo.findFirstByUserId(UserId);
        if(userEntity != null) {
            userRepo.deleteByUserId(UserId);
            return true;
        }
        return false;
    }
    public List<UserBasicDto> listAll() {
        List<UserEntity> users = userRepo.findAll();
        if(users.size() >0){
            return userMapper.toBasicDtos(users);
        }
        return new ArrayList<>();
    }
    public UserBasicDto updateUser(UserBasicDto user, UUID UserId) {
        UserEntity oldUser = userRepo.findFirstByUserId(UserId);
        UserEntity userEntity = userMapper.fromBasicToEntity(user);
        userEntity.setUserId(UserId);
        userEntity.setPassword(oldUser.getPassword());
        UserEntity returnUser = userRepo.saveAndFlush(userEntity);
        return userMapper.toBasicDto(returnUser);
    }
}
