package pl.teo.petshop.validation;

import pl.teo.petshop.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MatchingPasswordValidator implements ConstraintValidator<MatchingPassword, UserDto> {
    @Override
    public void initialize(MatchingPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext constraintValidatorContext) {
        if(userDto.getPassword() == null || userDto.getDoubledPassword() == null){
            return true;
        }
        boolean valid = userDto.getPassword().equals(userDto.getDoubledPassword());
        if (!valid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Passwords do not match!")
                    .addPropertyNode("doubledPassword").addConstraintViolation();
        }
        return valid;
    }
}
