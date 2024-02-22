package com.yeison.demo.service.impl;

import com.yeison.demo.domain.Product;
import com.yeison.demo.repository.InventarioRepository;
import com.yeison.demo.service.InventarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InventarioServiceImpl implements InventarioService {

    private final InventarioRepository repository;

    @Override
    public Product save() {

        Product productToSave = Product.builder()
                .nombre("Teléfono inteligente Samsung Galaxy A32")
                .descripcion("Teléfono inteligente con pantalla Super AMOLED de 6.4 pulgadas, cámara cuádruple de 64 MP y batería de larga duración.")
                .precio(589900)
                .stock(50)
                .build();

        repository.save(productToSave);

        return productToSave;
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product saveProduct(@RequestBody Product product) {

        Product productToSave = Product.builder()
                .nombre("Teléfono inteligente Samsung Galaxy A32")
                .descripcion("Teléfono inteligente con pantalla Super AMOLED de 6.4 pulgadas, cámara cuádruple de 64 MP y batería de larga duración.")
                .precio(589900)
                .stock(50)
                .build();

        repository.save(productToSave);

        return productToSave;
    }

    @Override
    public Product getProductById(int id) {

        return repository.findById(id).get();
    }

    @Override
    public Boolean delete(int id) {
        Product product = repository.findById(id).get();
        try {
            repository.delete(product);
            return true;
        } catch (Error error) {
            return false;
        }
    }
}
