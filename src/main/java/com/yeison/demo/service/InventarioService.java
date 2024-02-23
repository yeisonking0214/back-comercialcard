package com.yeison.demo.service;

import com.yeison.demo.domain.Producto;

import java.util.List;
import java.util.Map;

public interface InventarioService {


    List<Producto> getAll();

    Map<String, Object> getInventoryData();

    Map<String, Object> getProductsCombinationByPrice(Double precio);

    Producto saveProduct(Producto product);

    Boolean delete(int id);

    Producto getProductById(int id);

    Boolean editProduct(int id);
}
