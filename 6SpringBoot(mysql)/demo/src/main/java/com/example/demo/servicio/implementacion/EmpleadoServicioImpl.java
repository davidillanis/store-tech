package com.example.demo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.entidad.Empleado;
import com.example.demo.modelo.repositorio.EmpleadoRespositorio;
import com.example.demo.servicio.EmpleadoServicio;

@Service
public class EmpleadoServicioImpl implements EmpleadoServicio {
    @Autowired
    private EmpleadoRespositorio jpa_persona;

    @Override
    public void agregarEntidad(Empleado e) {
        jpa_persona.save(e);
    }

    @Override
    public List<Empleado> getListaEntidad() {
        return jpa_persona.findAll();
    }

    @Override
    public Empleado getEntidad(String id) {
        return jpa_persona.findById(id).orElse(null);
    }

    @Override
    public void editarEntidad(Empleado e) {
        Empleado e_bd=jpa_persona.findById(e.getUser_emp()).orElse(null);
        if(e_bd!=null){
            e_bd.setPass_emp(e.getPass_emp());
            e_bd.setApe_emp(e.getApe_emp());
            e_bd.setCarg_emp(e.getCarg_emp());
            e_bd.setDir_emp(e.getDir_emp());
            e_bd.setFe_naci_emp(e.getFe_naci_emp());
            e_bd.setNom_emp(e.getNom_emp());
            e_bd.setSala_emp(e.getSala_emp());
            e_bd.setBoletas(null);
            jpa_persona.save(e_bd);
        }
    }

    @Override
    public void eliminarEntidad(String id) {
        jpa_persona.deleteById(id);
    }
    
}
