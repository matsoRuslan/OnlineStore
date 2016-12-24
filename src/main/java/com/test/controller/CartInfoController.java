package com.test.controller;

import com.test.dao.CartDao;
import com.test.entity.Cart;
import com.test.entity.CartProduct;
import com.test.entity.Product;
import com.test.service.CartProductService;
import com.test.service.CartService;
import com.test.service.ProductService;
import com.test.service.UserService;
import com.test.service.impl.PrincipalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class CartInfoController {
    private static UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        CartInfoController.userService = userService;
    }

    private static CartService cartService;

    @Autowired
    public void setCartService(CartService cartService) {
        CartInfoController.cartService = cartService;
    }

    private static CartDao cartDao;

    @Autowired
    public void setCartDao(CartDao cartDao) {
        CartInfoController.cartDao = cartDao;
    }

    private static ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        CartInfoController.productService = productService;
    }

    private static CartProductService cartProductService;

    @Autowired
    public void setCartProductService(CartProductService cartProductService) {
        CartInfoController.cartProductService = cartProductService;
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getUserCart() {
        Long id = userService.findByUserName(PrincipalServiceImpl.getPrincipal()).getId();
        return "redirect:/cart-info?user=" + id;
    }

    @RequestMapping(value = "/cart-info", method = RequestMethod.GET)
    public String getUserCartByID(@RequestParam(value = "user") Long id, Model model) {
        if (!PrincipalServiceImpl.getPrincipal().equals(userService.findById(id).getUserName())) {
            return "redirect:/Access_Denied";
        }
        Cart cart = cartService.findByUserId(id);
        model.addAttribute("cart", cart);
        Long cartId = cartService.findByUserId(id).getId();
        model.addAttribute("cartID", cartId);
        return "cart-info";
    }

    @RequestMapping(value = "/shipping-address", method = RequestMethod.POST)
    public String saveShippingAddress(@ModelAttribute("cart") Cart cart, Model model) {
        Cart myCart = cartService.findById(cart.getId());
        Long id = myCart.getUser().getId();
        myCart.setShippingAddress(cart.getShippingAddress());
        cartService.update(myCart);
        return "redirect:/cart-info?user=" + id;
    }

    @RequestMapping(value = "/add-to-cart", method = RequestMethod.GET)
    public String addToCart(@RequestParam(value = "product") Long id, Model model) {
        Long userId = userService.findByUserName(PrincipalServiceImpl.getPrincipal()).getId();
        Cart cart = cartService.findByUserId(userId);
        Product product = productService.findById(id);
        product.setAmount(product.getAmount() - 1);
        productService.update(product);
        CartProduct cartProduct = new CartProduct();
        cartProduct.setProductBought(false);
        cartProduct.setProduct(productService.findById(id));
        cartProductService.persist(cartProduct);
        List<CartProduct> cartProducts = cart.getCartProducts();
        cartProducts.add(cartProduct);
        cart.setCartProducts(cartProducts);
        cartService.update(cart);
        model.addAttribute("123", "123");
        return "redirect:/shop-item/" + id;
    }

    @RequestMapping(value = "/cart-info", method = RequestMethod.POST)
    public String saveUserCart(@RequestParam(value = "user") Long id, @ModelAttribute("cart") Cart cart, BindingResult bindingResult, Model model) {
        cartService.update(cart);
        model.addAttribute("submitDone", "done");
        return "cart-info";
    }

    @RequestMapping(value = "/confirm-purchase", method = RequestMethod.POST)
    @ResponseBody
    public void confirmPurchase(@RequestBody String json) {
        Long cartProductId = Long.parseLong(json, 10);
        CartProduct cartProduct = cartProductService.findById(cartProductId);
        cartProduct.setProductBought(true);
        cartProductService.update(cartProduct);
    }

    @RequestMapping(value = "/delete-from-cart", method = RequestMethod.POST)
    @ResponseBody
    public void deleteFromCart(@RequestBody String json) {
        Long cartProductId = Long.parseLong(json, 10);
        CartProduct cartProduct = cartProductService.findById(cartProductId);
        Product product = cartProduct.getProduct();
        product.setAmount(product.getAmount() + 1);
        productService.update(product);
        cartProductService.delete(cartProduct.getId());
    }
}
