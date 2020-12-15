package com.example.gswsch7ex5.controllers;

import com.example.gswsch7ex5.model.Product;
import com.example.gswsch7ex5.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {

  private final ProductService productService;

  public ProductsController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/products")
  public String viewProducts(Model model) {
    model.addAttribute("products", productService.findAll());
    return "products.html";
  }

  @PostMapping("/products")
  public String addProduct(
      @RequestParam String name,
      @RequestParam double price,
      Model model
  ) {
    Product p = new Product();
    p.setName(name);
    p.setPrice(price);
    productService.addProduct(p);
    model.addAttribute("products", productService.findAll());
    return "products.html";
  }
}
