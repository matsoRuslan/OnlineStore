package com.test.controller;

import com.test.service.ProductService;
import com.test.service.impl.PrincipalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UtilController {
    private static ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        UtilController.productService = productService;
    }

    @RequestMapping(value = "/shop-item/{id}", method = RequestMethod.GET)
    public String shopItem() {
        return "shop-item";
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public String category() {
        return "category";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", PrincipalServiceImpl.getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "item-not-available", method = RequestMethod.GET)
    public String itemNotAvailablePage(ModelMap model) {
        model.addAttribute("user", PrincipalServiceImpl.getPrincipal());
        return "item-not-available";
    }

    @RequestMapping(value = "paging", method = RequestMethod.GET)
    public String paging(@RequestParam(value = "size") int size, @RequestParam(value = "page") int page, Model model) {
        int totalSize = productService.findAll().size();
        int pageCount = totalSize % size;
        if (pageCount == 0) {
            pageCount = totalSize / size;
        } else {
            pageCount = totalSize / size + 1;
        }
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        return "paging";
    }
}
