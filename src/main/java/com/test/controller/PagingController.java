package com.test.controller;

import com.test.entity.Product;
import com.test.service.PagingService;
import com.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Controller
@EnableWebMvc
public class PagingController {
    private static PagingService pagingService;

    @Autowired
    public void setPagingService(PagingService pagingService) {
        PagingController.pagingService = pagingService;
    }

    private static ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        PagingController.productService = productService;
    }


    @RequestMapping(value = "/product-page", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    ResponseEntity<List<Product>> findPage(@RequestParam(value = "size") int size, @RequestParam(value = "page") int page, @RequestParam(value = "search", required = false) String productSearch) {
        page = (page - 1) * size;
        List<Product> products = pagingService.findPaging(page, size);
        if (productSearch!= null &&!productSearch.equals("")) {
            products = productService.findBySearchString(productSearch);
        }
        if (products == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
