package com.example.demo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.entidad.BoletaInformacion;
import com.example.demo.modelo.repositorio.BoletaInformacionRepositorio;
import com.example.demo.servicio.BoletaInformacionServicio;

@Service
public class BoletaInformacionServicioImpl implements BoletaInformacionServicio{
    @Autowired
    private BoletaInformacionRepositorio jpa_boleta;

    @Override
    public void agregarEntidad(BoletaInformacion bi) {
        jpa_boleta.save(bi);
    }

    @Override
    public List<BoletaInformacion> getListaEntidad() {
        return jpa_boleta.findAll();
    }

    @Override
    public BoletaInformacion getEntidad(int id) {
        return jpa_boleta.findById(id).orElse(null);
    }
}
