package com.yeison.demo.controller;

import com.yeison.demo.domain.Product;
import com.yeison.demo.service.InventarioService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/inventario")
public class InventarioController {

    private final InventarioService service;

    @GetMapping("/test")
    private ResponseEntity<Product> test() {

        Product response = service.save();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    private ResponseEntity<List<Product>> getAll() {
        List<Product> response = service.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/test/{id}")
    private ResponseEntity<Product> getById(@PathVariable("id") String id) {
        return new ResponseEntity<>(service.getProductById(Integer.parseInt(id)), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
        return new ResponseEntity<>(service.delete(Integer.parseInt(id)), HttpStatus.OK);
    }

    @PostMapping("/test")
    private ResponseEntity<String> testePost() {
        return new ResponseEntity<>("true post", HttpStatus.OK);
    }
}
