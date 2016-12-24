package com.test.validator.impl;

import com.test.entity.User;
import com.test.validator.ProfileValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import java.util.regex.Pattern;

@Component("profileValidator")
public class ProfileValidatorImpl implements ProfileValidator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        ValidationUtils.rejectIfEmpty(errors, "firstName", "notEmpty");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "notEmpty");
        ValidationUtils.rejectIfEmpty(errors, "userName", "notEmpty");
        ValidationUtils.rejectIfEmpty(errors, "email", "notEmpty");
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "notEmpty");
        ValidationUtils.rejectIfEmpty(errors, "address", "notEmpty");


        if (!Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$")
                .matcher(user.getEmail())
                .matches()) {
            errors.rejectValue("email", "emailTemplate");
        }

        if (!Pattern.compile("^\\+(?:[0-9] ?){6,14}[0-9]$")
                .matcher(user.getPhoneNumber())
                .matches()) {
            errors.rejectValue("phoneNumber", "phoneTemplate");
        }
    }
}
