package com.test.controller;

import com.test.validator.CategoryValidator;
import com.test.util.FileBucket;
import com.test.validator.ProductValidator;
import com.test.validator.ProfileValidator;
import com.test.entity.*;
import com.test.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class AdminController {
    private static UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        AdminController.userService = userService;
    }

    private static ImageService imageService;

    @Autowired
    public void setImageService(ImageService imageService) {
        AdminController.imageService = imageService;
    }

    private static CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        AdminController.categoryService = categoryService;
    }

    private static ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        AdminController.productService = productService;
    }

    private static CartProductService cartProductService;

    @Autowired
    public void setCartProductService(CartProductService cartProductService) {
        AdminController.cartProductService = cartProductService;
    }

    private static ProfileValidator profileValidator;

    @Autowired
    public void setProfileValidator(ProfileValidator profileValidator) {
        AdminController.profileValidator = profileValidator;
    }

    private static CategoryValidator categoryValidator;

    @Autowired
    public void setCategoryValidator(CategoryValidator categoryValidator) {
        AdminController.categoryValidator = categoryValidator;
    }

    private static ProductValidator productValidator;

    @Autowired
    public void setProductValidator(ProductValidator productValidator) {
        AdminController.productValidator = productValidator;
    }

    @RequestMapping(value = "/admin-config/edit-users", method = RequestMethod.GET)
    public String adminConfigUsers(Model model) {
        int totalSize = productService.findAll().size();
        model.addAttribute("totalSize", totalSize);
        return "admin-config-users";
    }

    @RequestMapping(value = "/admin-config/edit-categories", method = RequestMethod.GET)
    public String adminConfigCategories(Model model) {
        int totalSize = productService.findAll().size();
        model.addAttribute("totalSize", totalSize);
        return "admin-config-categories";
    }


    @RequestMapping(value = "/admin-config/adm-edit-user", method = RequestMethod.GET)
    public String getUserProfileByID(@RequestParam(value = "user") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "adm-edit-user";
    }

    @RequestMapping(value = "/admin-config/adm-edit-user", method = RequestMethod.POST)
    public String saveUserProfile(@RequestParam(value = "user") Long id, @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        Role role = userService.findById(id).getRole();
        user.setRole(role);
        profileValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("submitNotDone", "notDone");
            return "adm-edit-user";
        }
        userService.update(user);
        model.addAttribute("submitDone", "done");
        return "adm-edit-user";
    }

    @RequestMapping(value = "/admin-config/adm-edit-category", method = RequestMethod.GET)
    public String getCategoryByID(@RequestParam(value = "category") Long id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "adm-edit-category";
    }

    @RequestMapping(value = "/admin-config/adm-edit-category", method = RequestMethod.POST)
    public String saveCategoryByID(@RequestParam(value = "category") Long id, @ModelAttribute("category") Category category, BindingResult bindingResult, Model model) {
        categoryValidator.validate(category, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("submitNotDone", "notDone");
            return "adm-edit-category";
        }

        Category parent;
        if (category.getParent() == null || category.getParent().getTitle().equals("")) {
            parent = null;
        } else {
            parent = categoryService.findByTitle(category.getParent().getTitle());
            parent.setHasChildren(true);
            categoryService.update(parent);
        }
        category.setParent(parent);
        categoryService.update(category);
        model.addAttribute("submitDone", "done");
        return "adm-edit-category";
    }

    @RequestMapping(value = "/admin-config/adm-add-category", method = RequestMethod.GET)
    public String getCategoryToAdd(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "adm-add-category";
    }

    @RequestMapping(value = "/admin-config/adm-add-category", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("category") Category category, BindingResult bindingResult, Model model) {
        categoryValidator.validate(category, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("submitNotDone", "notDone");
            return "adm-add-category";
        }

        Category parent;
        if (category.getParent() == null || category.getParent().getTitle().equals("")) {
            parent = null;
        } else {
            parent = categoryService.findByTitle(category.getParent().getTitle());
            parent.setHasChildren(true);
            categoryService.update(parent);
        }
        category.setParent(parent);
        categoryService.persist(category);
        model.addAttribute("submitDone", "done");
        return "adm-add-category";
    }

    @RequestMapping(value = "/admin-config/adm-delete-product", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam(value = "product") Long id) {
        List<CartProduct> cartProducts = cartProductService.findByProduct(id);
        for (CartProduct cartProduct : cartProducts
                ) {
            cartProductService.delete(cartProduct.getId());
        }
        productService.delete(id);
        int totalSize = productService.findAll().size();
        return "redirect:/admin-config/edit-products-paging?size=" + totalSize + "&page=1";
    }

    @RequestMapping(value = "/admin-config/adm-add-product", method = RequestMethod.GET)
    public String getProductToAdd(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        FileBucket fileModel = new FileBucket();
        model.addAttribute("fileBucket", fileModel);
        return "adm-add-product";
    }

    @RequestMapping(value = "/admin-config/adm-add-product", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("fileBucket") FileBucket fileBucket, @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
        productValidator.validate(product, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("submitNotDone", "notDone");
            return "adm-add-product";
        }
        product.setActive(true);
        Category category = categoryService.findByTitle(product.getCategory().getTitle());
        product.setCategory(category);
        if (product.getImage() == null) {
            Image image = new Image();
            imageService.persist(image);
            product.setImage(image);
        }
        productService.persist(product);
        return "redirect:/admin-config/adm-add-product/" + product.getId();

    }

    @RequestMapping(value = "/admin-config/adm-add-product/{id}", method = RequestMethod.GET)
    public String getProductToAddWithId(Model model, @PathVariable("id") Long id) {
        model.addAttribute("product", productService.findById(id));
        FileBucket fileModel = new FileBucket();
        model.addAttribute("fileBucket", fileModel);
        model.addAttribute("cteated", "true");
        return "adm-add-product";
    }

    @RequestMapping(value = "/admin-config/adm-add-product/{id}", method = RequestMethod.POST)
    public String saveProductImg(@ModelAttribute("product") Product product, @ModelAttribute("fileBucket") FileBucket fileBucket, BindingResult bindingResult, Model model, @PathVariable("id") Long id) {
        product = productService.findById(id);
        MultipartFile multipartFile = fileBucket.getFile();
        Image image = product.getImage();
        try {
            image.setImage(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageService.update(image);
        product.setImage(image);
        if (product.getImage() == null) {
            image = new Image();
            imageService.persist(image);
            product.setImage(image);
        }
        productService.update(product);
        int totalSize = productService.findAll().size();
        return "redirect:/admin-config/edit-products-paging?size=" + totalSize + "&page=1";
    }

    @RequestMapping(value = "/admin-config/adm-edit-product", method = RequestMethod.GET)
    public String getProductByID(@RequestParam(value = "product") Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "adm-edit-product";
    }

    @RequestMapping(value = "/admin-config/adm-edit-product", method = RequestMethod.POST)
    public String saveProduct(@RequestParam(value = "product") Long id, @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
        productValidator.validate(product, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("submitNotDone", "notDone");
            return "adm-edit-product";
        }
        Category category = categoryService.findByTitle(product.getCategory().getTitle());
        product.setCategory(category);
        Image image = imageService.findById(product.getImage().getId());
        product.setImage(image);
        productService.update(product);
        model.addAttribute("submitDone", "done");
        return "redirect:/admin-config/adm-edit-product/" + product.getId();
    }

    @RequestMapping(value = "/admin-config/adm-edit-product/{id}", method = RequestMethod.GET)
    public String getProductToEditWithId(Model model, @PathVariable("id") Long id) {
        model.addAttribute("product", productService.findById(id));
        FileBucket fileModel = new FileBucket();
        model.addAttribute("fileBucket", fileModel);
        model.addAttribute("cteated", "true");
        Long productId = id;
        model.addAttribute("productId", productId);
        int totalSize = productService.findAll().size();
        model.addAttribute("totalSize", totalSize);
        return "adm-edit-product";
    }

    @RequestMapping(value = "/admin-config/adm-edit-product/{id}", method = RequestMethod.POST)
    public String editProductImg(@ModelAttribute("product") Product product, @ModelAttribute("fileBucket") FileBucket fileBucket, BindingResult bindingResult, Model model, @PathVariable("id") Long id) {
        product = productService.findById(id);
        MultipartFile multipartFile = fileBucket.getFile();
        Image image = product.getImage();
        try {
            image.setImage(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageService.update(image);
        product.setImage(image);
        if (product.getImage() == null) {
            image = new Image();
            imageService.persist(image);
            product.setImage(image);
        }
        productService.update(product);
        return "redirect:/admin-config/adm-edit-product/" + id;
    }

    @RequestMapping(value = "/admin-config/edit-products-paging", method = RequestMethod.GET)
    public String adminPaging(@RequestParam(value = "size") int size, @RequestParam(value = "page") int page, Model model, @RequestParam(value = "search", required = false) String productSearch) {
        int totalSize = productService.findAll().size();
        int pageCount = totalSize % size;
        if (pageCount == 0) {
            pageCount = totalSize / size;
        } else {
            pageCount = totalSize / size + 1;
        }
        model.addAttribute("productSearch", productSearch);
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("totalSize", totalSize);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        return "admin-config-products";
    }
}
