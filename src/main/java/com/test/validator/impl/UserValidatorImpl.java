package com.test.validator.impl;

import com.test.entity.User;
import com.test.service.UserService;
import com.test.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import java.util.regex.Pattern;

@Component("userValidator")
public class UserValidatorImpl implements UserValidator {

    private static UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        UserValidatorImpl.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        ValidationUtils.rejectIfEmpty(errors, "firstName", "notEmpty");
        ValidationUtils.rejectIfEmpty(errors, "email", "notEmpty");
        ValidationUtils.rejectIfEmpty(errors, "userName", "notEmpty");
        ValidationUtils.rejectIfEmpty(errors, "password", "notEmpty");
        ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "notEmpty");


        if (!Pattern.compile("^(\\S){8,24}$")
                .matcher(user.getPassword())
                .matches()) {
            errors.rejectValue("password", "passwordSize");
        }

        if (!Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$")
                .matcher(user.getEmail())
                .matches()) {
            errors.rejectValue("email", "emailTemplate");
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "passwordMatch");
        }

        if (userService.findByUserName(user.getUserName()) != null) {
            errors.rejectValue("userName", "userNameDuplicate");
        }
    }
}
