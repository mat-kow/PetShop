package pl.teo.petshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity @Getter @Setter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20, unique = true, nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    private String roles;
    private Boolean active;
    @Column(nullable = false, unique = true, length = 50)
    private String email;
    @OneToOne
    private UserDetails userDetails;

    public User() {
    }

    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                userName.equals(user.userName) &&
                password.equals(user.password) &&
                Objects.equals(roles, user.roles) &&
                Objects.equals(active, user.active) &&
                email.equals(user.email) &&
                Objects.equals(userDetails, user.userDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, roles, active, email, userDetails);
    }
}
