package pl.teo.petshop.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 20, unique = true, nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    private String roles;
    private boolean active;
    @Column(nullable = false, unique = true, length = 50)
    private String email;
    @OneToOne
    private UserDetails userDetails;

    public User() {
    }
    public User(String userName, String password, String roles, boolean active) {
        this.userName = userName;
        this.password = password;
        this.roles = roles;
        this.active = active;
    }
    public User(String userName, String password, String roles, boolean active, String email) {
        this.userName = userName;
        this.password = password;
        this.roles = roles;
        this.active = active;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }



    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
