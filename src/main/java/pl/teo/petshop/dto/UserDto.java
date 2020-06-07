package pl.teo.petshop.dto;

import pl.teo.petshop.validation.MatchingPassword;
import pl.teo.petshop.validation.UniqueEmail;
import pl.teo.petshop.validation.UniqueUserName;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@MatchingPassword
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getUserName() {
        return userName;
    }

    public String getDoubledPassword() {
        return doubledPassword;
    }

    public void setDoubledPassword(String doubledPassword) {
        this.doubledPassword = doubledPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public UserDetailsDto getUserDetailsDto() {
        return userDetailsDto;
    }

    public void setUserDetailsDto(UserDetailsDto userDetailsDto) {
        this.userDetailsDto = userDetailsDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
