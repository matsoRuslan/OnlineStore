package com.test.controller;

import com.test.service.impl.PrincipalServiceImpl;
import com.test.validator.ProfileValidator;
import com.test.entity.Role;
import com.test.entity.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {
    private static UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        ProfileController.userService = userService;
    }

    private static ProfileValidator profileValidator;

    @Autowired
    public void setProfileValidator(ProfileValidator profileValidator) {
        ProfileController.profileValidator = profileValidator;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getUserProfile() {
        Long id = userService.findByUserName(PrincipalServiceImpl.getPrincipal()).getId();
        return "redirect:/profile-info?user=" + id;
    }

    @RequestMapping(value = "/profile-info", method = RequestMethod.GET)
    public String getUserProfileByID(@RequestParam(value = "user") Long id, Model model) {
        if (!PrincipalServiceImpl.getPrincipal().equals(userService.findById(id).getUserName())) {
            return "redirect:/Access_Denied";
        }
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "profile-info";
    }

    @RequestMapping(value = "/profile-info", method = RequestMethod.POST)
    public String saveUserProfile(@RequestParam(value = "user") Long id, @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        Role role = userService.findById(id).getRole();
        user.setRole(role);
        profileValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("submitNotDone", "notDone");
            return "profile-info";
        }
        userService.update(user);
        model.addAttribute("submitDone", "done");
        return "profile-info";
    }
}
