package pl.teo.petshop.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.teo.petshop.validation.MatchingPassword;
import pl.teo.petshop.validation.UniqueEmail;
import pl.teo.petshop.validation.UniqueUserName;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@MatchingPassword @Getter @Setter @NoArgsConstructor
public class UserDto {
    private Long id;
    @UniqueUserName @Size(min = 3, max = 20, message = "{Size.UserDto.userName}")
    private String userName;
    @Size(min = 3, message = "{Size.UserDto.password}")
    private String password;
    private String doubledPassword;
    @Email(message = "{Email.UserDto.email}") @UniqueEmail @NotBlank(message = "{NotBlank.UserDto}")
    private String email;
    private UserDetailsDto userDetailsDto;
    private String roles;
    private Boolean active;

    public UserDto(String userName, String password, String email, Boolean active, String roles) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.roles = roles;
        this.active = active;
    }

    public UserDto(String userName, String password,String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) &&
                userName.equals(userDto.userName) &&
                password.equals(userDto.password) &&
                Objects.equals(doubledPassword, userDto.doubledPassword) &&
                email.equals(userDto.email) &&
                Objects.equals(userDetailsDto, userDto.userDetailsDto) &&
                roles.equals(userDto.roles) &&
                active.equals(userDto.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, doubledPassword, email, userDetailsDto, roles, active);
    }
}
