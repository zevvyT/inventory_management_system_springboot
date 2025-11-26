package com.inventory.controller;

import com.inventory.model.Product;
import com.inventory.model.ProductCategory;
import com.inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Make categories available to all views
    @ModelAttribute("categories")
    public ProductCategory[] getCategories() {
        return ProductCategory.values();
    }

    // Redirect root to product list
    @GetMapping("/")
    public String home() {
        return "redirect:/products";
    }

    // Display all products
    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product-list";
    }

    // Show form for creating new product
    @GetMapping("/products/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("isEdit", false);
        return "product-form";
    }

    // Save new product
    @PostMapping("/products")
    public String createProduct(@ModelAttribute("product") Product product,
            RedirectAttributes redirectAttributes) {
        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("message", "Product created successfully!");
        return "redirect:/products";
    }

    // Show form for editing existing product
    @GetMapping("/products/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("product", product);
        model.addAttribute("isEdit", true);
        return "product-form";
    }

    // Update existing product
    @PostMapping("/products/update/{id}")
    public String updateProduct(@PathVariable("id") Long id,
            @ModelAttribute("product") Product product,
            RedirectAttributes redirectAttributes) {
        product.setId(id);
        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("message", "Product updated successfully!");
        return "redirect:/products";
    }

    // Delete product
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id,
            RedirectAttributes redirectAttributes) {
        productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("message", "Product deleted successfully!");
        return "redirect:/products";
    }
}
