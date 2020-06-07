package pl.teo.petshop.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.teo.petshop.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@Scope("prototype")
public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {
   private final UserRepository userRepository;

   @Autowired
   public UniqueUserNameValidator(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   public void initialize(UniqueUserName constraint) {
   }

   public boolean isValid(String value, ConstraintValidatorContext context) {
      return !userRepository.existsByUserName(value);
   }
}
