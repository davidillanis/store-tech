package com.example.demo.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.entidad.Empleado;
import com.example.demo.servicio.EmpleadoServicio;

//http://localhost:8083/api/emp/list
@RestController
@RequestMapping(path = {"/api/emp"})
public class EmpleadoControlador {
    @Autowired
    private EmpleadoServicio empleadoServicio;

    @GetMapping("/list")
    public List<Empleado> listarPersona(){
        return empleadoServicio.getListaEntidad();
    }

}
