package com.example.demo.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.entidad.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, String>{
}
