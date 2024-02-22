package com.yeison.demo.service;

import com.yeison.demo.domain.Product;

import java.util.List;

public interface InventarioService {

    Product save();

    List<Product> getAll();

    Product saveProduct(Product product);

    Boolean delete(int id);

    Product getProductById(int id);
}
