package com.example.gswsch7ex5.services;

import com.example.gswsch7ex5.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

  private List<Product> products = new ArrayList<>();

  public void addProduct(Product p) {
    products.add(p);
  }

  public List<Product> findAll() {
    return products;
  }

  public List<Product> queryForProductName(String query) {
    return products.stream()
            .filter(p -> p.getName().contains(query))
            .collect(Collectors.toList());
  }
}
