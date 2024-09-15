package com.example.demo.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.entidad.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, String>{
}
