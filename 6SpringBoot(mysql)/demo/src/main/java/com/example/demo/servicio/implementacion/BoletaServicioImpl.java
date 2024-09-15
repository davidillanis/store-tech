package com.example.demo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.entidad.Boleta;
import com.example.demo.modelo.repositorio.BoletaRepositorio;
import com.example.demo.servicio.BoletaServicio;

@Service
public class BoletaServicioImpl implements BoletaServicio{
    @Autowired
    private BoletaRepositorio jpa_boleta;

    @Override
    public void agregarEntidad(Boleta b) {
        jpa_boleta.save(b);
    }

    @Override
    public List<Boleta> getListaEntidad() {
        return jpa_boleta.findAll();
    }

    @Override
    public Boleta getEntidad(String id) {
        return jpa_boleta.findById(id).orElse(null);
    }

    @Override
    public boolean editarEntidad(Boleta b) {
        if(jpa_boleta.findById(b.getCod_bol()).orElse(null)!=null){
            jpa_boleta.save(b);
            return true;
        }
        return false;
    }

    @Override
    public void eliminarEntidad(String id) {
        jpa_boleta.deleteById(id);
    }
    
}
