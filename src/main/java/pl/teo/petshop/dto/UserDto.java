package pl.teo.petshop.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UserDto {
    private Long id;
    @Size(min = 3, max = 20, message = "Login musi mieć od 3do 20 znaków")
    private String userName;
    @Size(min = 3, message = "Hasło za krótkie")
    private String password;
    @Email
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
