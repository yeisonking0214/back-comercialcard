package com.yeison.demo.repository;

import com.yeison.demo.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface InventarioRepository extends JpaRepository<Producto, Integer> {

    // JPQL
    //@Query(value = "SELECT * FROM Producto WHERE ", nativeQuery = true)
    //@Query("SELECT p FROM Product p")
    //List<Product> getProdcutsOnly10Dollars();

    //@Query("INSERT INTO Product p (p.nombre, p.descripcion, p.precio, p.stock) VALUES ('Teléfono inteligente Samsung Galaxy A32', 'Teléfono inteligente con pantalla Super AMOLED de 6.4 pulgadas, cámara cuádruple de 64 MP y batería de larga duración.', 589900, 50)")
    //List<Product> crear();

    //List<Product> getProductWhereNameIsMaria();


    @Query("SELECT p FROM Producto p WHERE p.precio = (SELECT MAX(precio) FROM Producto)")
    Producto findProductWithMaxPrice();

    @Query("SELECT CAST(SUM(p.precio * p.stock) AS java.math.BigDecimal) FROM Producto p")
    BigDecimal getTotalInventoryValue();
}
