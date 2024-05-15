package com.in.blog.Blogg_Api.Payloads;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
@Data
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Integer id;
    @NotEmpty
    @Size(min = 4, message="User name Must be min 4 character ")
    private String name;
//    @Email(message = "email should be valid!!")
    @Pattern(regexp="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "please filled valid email")
    private String email;
    @NotEmpty
    @Size(min = 4, message = "Password should be greater than 4 character!!", max = 10)
    private String password;
    @NotEmpty
    private String about;
}
