package com.yeison.demo.service.impl;

import com.yeison.demo.domain.Producto;
import com.yeison.demo.repository.InventarioRepository;
import com.yeison.demo.service.InventarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class InventarioServiceImpl implements InventarioService {

    private final InventarioRepository repository;


    @Override
    public List<Producto> getAll() {
        return repository.findAll();
    }
    @Override
    public Boolean editProduct(int id) {
        Producto product = repository.findById(id).get();
        repository.save(product);
        return true;
    }

    @Override
    public Map<String, Object> getInventoryData() {
        Map<String, Object> responseData = new HashMap<>();
        Producto productoMayorPrecio = repository.findProductWithMaxPrice();
        BigDecimal valorTotalInventario = repository.getTotalInventoryValue();
        responseData.put("productoMayorPrecio", productoMayorPrecio);
        responseData.put("valorTotalInventario", valorTotalInventario);

        return responseData;
    }

    @Override
    public Map<String, Object> getProductsCombinationByPrice(Double precio) {
        Map<String, Object> responseData = new HashMap<>();
        return responseData;
    }


    @Override
    public Producto saveProduct(@RequestBody Producto product) {
        repository.save(product);
        return product;
    }

    @Override
    public Producto getProductById(int id) {

        return repository.findById(id).get();
    }

    @Override
    public Boolean delete(int id) {
        Producto product = repository.findById(id).get();
        repository.delete(product);
        return true;
    }
}
