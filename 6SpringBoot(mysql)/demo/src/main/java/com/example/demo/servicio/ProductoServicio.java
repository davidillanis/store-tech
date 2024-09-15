package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.entidad.Producto;

public interface ProductoServicio {
    public void agregarEntidad(Producto p);
    public List<Producto> getListaEntidad();
    public Producto getEntidad(String id);
    public boolean editarEntidad(String id, Producto p);
    public void eliminarEntidad(String id);
}
