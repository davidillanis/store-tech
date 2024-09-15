package com.example.demo.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.entidad.Empleado;

@Repository
public interface EmpleadoRespositorio extends JpaRepository<Empleado, String>{
}
