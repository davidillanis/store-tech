package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.entidad.BoletaInformacion;
import com.example.demo.servicio.BoletaInformacionServicio;

//http://localhost:8083/api/b_i/list
@RestController
@RequestMapping(path = {"/api/b_i"})
public class BoletaInformacionControlador {
    @Autowired
    private BoletaInformacionServicio boletaInformacionServicio;

    @GetMapping(path = {"/list"})
    public List<BoletaInformacion> listarBoletaInformacion(){
        return boletaInformacionServicio.getListaEntidad();
    }
}
