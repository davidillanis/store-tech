package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.entidad.BoletaInformacion;

public interface BoletaInformacionServicio {
    public void agregarEntidad(BoletaInformacion bi);
    public List<BoletaInformacion> getListaEntidad();
    public BoletaInformacion getEntidad(int id);
}
