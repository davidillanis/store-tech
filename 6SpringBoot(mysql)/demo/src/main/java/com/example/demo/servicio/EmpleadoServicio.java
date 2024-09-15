package com.example.demo.servicio;

import java.util.List;

import com.example.demo.modelo.entidad.Empleado;

public interface EmpleadoServicio {
    public void agregarEntidad(Empleado e);
    public List<Empleado> getListaEntidad();
    public Empleado getEntidad(String id);
    public void editarEntidad(Empleado e);
    public void eliminarEntidad(String id);
}
