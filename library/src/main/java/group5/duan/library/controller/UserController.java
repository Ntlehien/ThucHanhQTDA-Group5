package group5.duan.library.controller;

import group5.duan.library.Service.user.IUserService;
import group5.duan.library.dto.AuthenticationRequestDto;
import group5.duan.library.dto.UserBasicDto;
import group5.duan.library.dto.UserCreateDto;
import group5.duan.library.dto.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

     private final IUserService userService;


    public UserController(IUserService userService) {
        this.userService = userService;
    }
    @GetMapping("/user")
    public ResponseEntity<List<UserBasicDto>> list() {
        try {
            List<UserBasicDto> users = userService.listAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
        }catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/user/{UserId}")
    public ResponseEntity<UserBasicDto> get(@PathVariable UUID UserId) {
        try {
            UserBasicDto user = userService.getById(UserId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user")
    public  ResponseEntity<UserBasicDto> create(@RequestBody UserCreateDto newUser) throws Exception {
        try {
            UserBasicDto userReturn = userService.createUser(newUser);
            return new ResponseEntity<>(userReturn,HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/user/{UserId}")
    public ResponseEntity<UserBasicDto> update(@RequestBody UserBasicDto user, @PathVariable UUID UserId) throws Exception {
        try {
            UserBasicDto userDto = userService.updateUser(user, UserId);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{UserId}")
    public ResponseEntity<HttpStatus> delete(@PathVariable UUID UserId) {
        try {
            userService.delete(UserId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequestDto authenticationRequestDto) throws Exception {
        UserInfoDto userInfoDto = userService.login(authenticationRequestDto);
        return new ResponseEntity<>(userInfoDto, HttpStatus.OK);
    }
}
