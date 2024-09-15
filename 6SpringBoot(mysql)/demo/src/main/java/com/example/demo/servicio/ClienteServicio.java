package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.entidad.Cliente;

public interface ClienteServicio {
    public void agregarEntidad(Cliente c);
    public List<Cliente> getListaEntidad();
    public Cliente getEntidad(String id);
    public void editarEntidad(Cliente c);
    public void eliminarEntidad(String id);
}
