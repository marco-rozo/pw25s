package br.edu.utfpr.pb.pw25s.serverproject.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueEmailValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {
    String message() default "{br.edu.utfpr.pb.pw25s.email.Unique}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
