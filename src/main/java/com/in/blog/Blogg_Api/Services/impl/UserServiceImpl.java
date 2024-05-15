package com.in.blog.Blogg_Api.Services.impl;
import com.in.blog.Blogg_Api.Entity.User;
import com.in.blog.Blogg_Api.Exceptions.ResourcesNotFoundExecption;
import com.in.blog.Blogg_Api.Payloads.UserDto;
import com.in.blog.Blogg_Api.Repository.UserRepo;
import com.in.blog.Blogg_Api.Services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
       User user= dtoToUser(userDto);
       User saveUser=userRepo.save(user);
      return userTOUserDto(saveUser);
    }
    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User existUser=userRepo.findById(userId)
                .orElseThrow(()->new ResourcesNotFoundExecption("User","Id",userId));
      existUser.setName(userDto.getName());
      existUser.setPassword(userDto.getPassword());
      existUser.setEmail(userDto.getEmail());
      existUser.setAbout(userDto.getAbout());
      User updatedUser=this.userRepo.save(existUser);
     return this.userTOUserDto(updatedUser);

    }
    @Override
    public UserDto getUserById(Integer userId) {
      User existUser=  this.userRepo.findById(userId)
              .orElseThrow(()->new ResourcesNotFoundExecption("User","Id",userId));
      return this.userTOUserDto(existUser);

    }
    @Override
    public List<UserDto> getAllUser() {
        List<User> users= this.userRepo.findAll();
        List<UserDto> userDtos=users.stream().map(user -> this.userTOUserDto(user))
                .collect(Collectors.toList());
        return userDtos;

    }
    @Override
    public void deleteUser(Integer userId) {
       User  existUser= this.userRepo.findById(userId).
                orElseThrow(()-> new ResourcesNotFoundExecption("User","Id",userId));
       this.userRepo.delete(existUser);

    }
    // this methords created by us but we can use that by model Mapping.
    // entity conversion
//    private User dtoToUser(UserDto userDto)
//    {
//        User user=new User();
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setAbout(userDto.getAbout());
//        user.setPassword(userDto.getPassword());
//        return user;
//    }
    //    private UserDto userTOUserDto(User user)
//    {
//        UserDto userDto=new UserDto();
//        userDto.setAbout(user.getAbout());
//        userDto.setEmail(user.getEmail());
//        userDto.setId(user.getId());
//        userDto.setPassword(user.getPassword());
//        userDto.setName(user.getName());
//        return userDto;
//
//    }

    // Conversion by using Model Mapping
    private User dtoToUser(UserDto userDto)
    {
      return modelMapper.map(userDto, User.class);
    }

private UserDto userTOUserDto(User user)
{
   return modelMapper.map(user,UserDto.class);
}
}
