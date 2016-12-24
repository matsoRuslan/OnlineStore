package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String Search(@RequestParam(value = "search") String productSearch, Model model) {
        model.addAttribute("productSearch", productSearch);
        return "search";
    }
}
