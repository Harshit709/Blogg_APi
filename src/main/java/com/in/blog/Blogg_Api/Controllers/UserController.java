package com.in.blog.Blogg_Api.Controllers;

import com.in.blog.Blogg_Api.Payloads.ApiResponse;
import com.in.blog.Blogg_Api.Payloads.UserDto;
import com.in.blog.Blogg_Api.Services.UserService;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
    {
       UserDto userDto1Created= this.userService.createUser(userDto);
       return  new ResponseEntity<>(userDto1Created,HttpStatus.CREATED);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer userId )
    {
       UserDto updateUser= userService.updateUser(userDto, userId);
       return new ResponseEntity<>(updateUser,HttpStatus.OK);

    }
    @DeleteMapping("/{userId}")
        public ResponseEntity<ApiResponse> deletUser(@PathVariable("userId")Integer userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted",true),HttpStatus.OK);
        }
        @GetMapping("/")
        public ResponseEntity<List<UserDto>> getAllUser()
        {
            return ResponseEntity.ok(userService.getAllUser());
        }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable("userId") Integer userID)
    {
        userService.getUserById(userID);
        return ResponseEntity.ok( userService.getUserById(userID));
    }

}
