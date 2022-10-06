package br.edu.utfpr.pb.pw25s.serverproject.validation;
;

import br.edu.utfpr.pb.pw25s.serverproject.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    UserRepository userRepository;

    public UniqueEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String email,
                           ConstraintValidatorContext constraintValidatorContext) {
        if (userRepository.findByEmail(email) == null) {
            return true;
        }
        return false;
    }
}
