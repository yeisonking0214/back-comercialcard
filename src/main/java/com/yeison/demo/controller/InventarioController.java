package com.yeison.demo.controller;

import com.yeison.demo.domain.Producto;
import com.yeison.demo.service.InventarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/inventario")
public class InventarioController {

    private final InventarioService service;

    @PostMapping("/productos")
    private ResponseEntity<Producto> save(@RequestBody Producto producto) {
        Producto response = service.saveProduct(producto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/productos")
    private ResponseEntity<List<Producto>> getAll() {
        List<Producto> response = service.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/productos/combinacion")
    private ResponseEntity<Map<String, Object>> getProductsCombinationByPrice(@PathVariable Double precio) {
        return new ResponseEntity<>(service.getProductsCombinationByPrice(precio), HttpStatus.OK);
    }

    @GetMapping("/info")
    private ResponseEntity<Map<String, Object>> getPInventoryData() {
        Map<String, Object> response = service.getInventoryData();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/productos/{id}")
    private ResponseEntity<Producto> getById(@PathVariable("id") String id) {
        return new ResponseEntity<>(service.getProductById(Integer.parseInt(id)), HttpStatus.OK);
    }


    @PutMapping("/productos/{id}")
    private ResponseEntity<Boolean> editProduct(@PathVariable("id") String id) {
        return new ResponseEntity<>(service.editProduct(Integer.parseInt(id)), HttpStatus.OK);
    }

    @DeleteMapping("/productos/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
        return new ResponseEntity<>(service.delete(Integer.parseInt(id)), HttpStatus.OK);
    }

}
