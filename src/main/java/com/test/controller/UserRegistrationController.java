package com.test.controller;

import com.test.validator.UserValidator;
import com.test.entity.Cart;
import com.test.entity.Role;
import com.test.entity.User;
import com.test.service.CartService;
import com.test.service.RoleService;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserRegistrationController {

    private static RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        UserRegistrationController.roleService = roleService;
    }

    private static CartService cartService;

    @Autowired
    public void setCartService(CartService cartService) {
        UserRegistrationController.cartService = cartService;
    }

    private static UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        UserRegistrationController.userService = userService;
    }

    private static UserValidator userValidator;

    @Autowired
    public void setUserValidator(UserValidator userValidator) {
        UserRegistrationController.userValidator = userValidator;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        user.setActive(true);
        Long id = 2L;
        Role role = roleService.findById(id);
        user.setRole(role);
        userService.persist(user);
        Cart cart = new Cart();
        cart.setShippingAddress(user.getAddress());
        cart.setUser(user);
        cartService.persist(cart);
        model.addAttribute("submitDone", "done");
        return "registration";
    }
}
