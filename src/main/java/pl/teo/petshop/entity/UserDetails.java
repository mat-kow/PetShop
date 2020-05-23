package pl.teo.petshop.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)//todo messages
    private long id;
    @Size(max = 20) @NotBlank @Column(length = 20)
    private String firstName;
    @Size(max = 20) @NotBlank @Column(length = 20)
    private String lastName;
    @Size(max = 100) @NotBlank @Column(length = 100)
    private String address;
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}")
    private String postCode;
    @Size(max = 20) @NotBlank @Column(length = 20)
    private String post;
    public UserDetails() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

}
