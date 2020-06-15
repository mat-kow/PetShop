package pl.teo.petshop.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
@Setter
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetailsDto that = (UserDetailsDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(address, that.address) &&
                Objects.equals(postCode, that.postCode) &&
                Objects.equals(post, that.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, postCode, post);
    }
}
