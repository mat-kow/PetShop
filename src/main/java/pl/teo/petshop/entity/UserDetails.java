package pl.teo.petshop.entity;

import javax.persistence.*;

@Entity
public class UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)//todo messages
    private Long id;
    @Column(length = 20)
    private String firstName;
    @Column(length = 20)
    private String lastName;
    @Column(length = 100)
    private String address;
    @Column (length = 6)
    private String postCode;
    @Column(length = 20)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
