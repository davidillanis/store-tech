package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.entidad.Boleta;
import com.example.demo.servicio.BoletaServicio;

//http://localhost:8083/api/bol/list
@RestController
@RequestMapping(path = {"/api/bol"})
public class BoletaControlador {
    @Autowired
    private BoletaServicio boletaServicio;

    @GetMapping("/list")
    public List<Boleta> listarBoleta(){
        return boletaServicio.getListaEntidad();
    }
}
