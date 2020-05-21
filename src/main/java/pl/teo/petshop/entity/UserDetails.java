package pl.teo.petshop.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(max = 20) @NotBlank @Column(length = 20)
    private String firstName;
    @Size(max = 20) @NotBlank @Column(length = 20)
    private String lastName;
    @Size(max = 20) @NotBlank @Column(length = 20)
    private String street;
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}")
    private String postCode;
    @Size(max = 20) @NotBlank @Column(length = 20)
    private String city;

    public UserDetails() {
    }

    public UserDetails(@Size(max = 20) @NotBlank String firstName, @Size(max = 20) @NotBlank String lastName,
                       @Size(max = 20) @NotBlank String street, @Pattern(regexp = "[0-9]{2}-[0-9]{3}") String postCode,
                       @Size(max = 20) @NotBlank String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.postCode = postCode;
        this.city = city;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
