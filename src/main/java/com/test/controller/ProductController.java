package com.test.controller;

import com.test.entity.Product;
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
public class ProductController {
    private static ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        ProductController.productService = productService;
    }

    @RequestMapping(value = "/product/", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<List<Product>> listAllProducts() {
        List<Product> products = productService.findAll();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        Product product = productService.findById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    ResponseEntity<List<Product>> getProductsByCategory(@RequestParam(value = "category") Long id) {
        List<Product> products = productService.findByCategory(id);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin-config/set-product-inactive", method = RequestMethod.POST)
    @ResponseBody
    public void setProductInactive(@RequestBody String json) {
        Long productId = Long.parseLong(json, 10);
        Product product = productService.findById(productId);
        product.setActive(false);
        productService.update(product);
    }

    @RequestMapping(value = "/admin-config/set-product-active", method = RequestMethod.POST)
    @ResponseBody
    public void setProductActive(@RequestBody String json) {
        Long productId = Long.parseLong(json, 10);
        Product product = productService.findById(productId);
        product.setActive(true);
        productService.update(product);
    }

    @RequestMapping(value = "/product-search", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<List<Product>> SearchProducts(@RequestParam(value = "search") String productSearch) {
        List<Product> products = productService.findBySearchString(productSearch);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
