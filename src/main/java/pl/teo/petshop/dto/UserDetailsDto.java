package pl.teo.petshop.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDetailsDto {
    private Long id;
    @Size(max = 20, message = "{Size.userDetailsDto.firstName}") @NotBlank(message = "{NotBlank.userDetailsDto}")
    private String firstName;
    @Size(max = 20, message = "{Size.userDetailsDto.lastName}") @NotBlank(message = "{NotBlank.userDetailsDto}")
    private String lastName;
    @Size(max = 100, message = "{Size.userDetailsDto.address}") @NotBlank(message = "{NotBlank.userDetailsDto}")
    private String address;
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}", message = "{Pattern.userDetailsDto.postCode}")
    private String postCode;
    @Size(max = 20, message = "{Size.userDetailsDto.post}") @NotBlank(message = "{NotBlank.userDetailsDto}")
    private String post;

    public String getFirstName() {
        return firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
