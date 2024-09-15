package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.entidad.Boleta;

public interface BoletaServicio {
    public void agregarEntidad(Boleta b);
    public List<Boleta> getListaEntidad();
    public Boleta getEntidad(String id);
    public boolean editarEntidad(Boleta b);
    public void eliminarEntidad(String id);
}
