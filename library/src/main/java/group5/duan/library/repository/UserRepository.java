package group5.duan.library.repository;

import group5.duan.library.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByUserName(String userName);
    UserEntity findFirstByUserId(UUID UserId);
    void deleteByUserId(UUID UserId);
    UserEntity findFirstByUserNameAndPassword(String username, String passWord);
}
