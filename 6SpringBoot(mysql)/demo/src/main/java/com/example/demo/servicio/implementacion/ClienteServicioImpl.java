package com.example.demo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.entidad.Cliente;
import com.example.demo.modelo.repositorio.ClienteRepositorio;
import com.example.demo.servicio.ClienteServicio;

@Service
public class ClienteServicioImpl implements ClienteServicio{
    @Autowired
    private ClienteRepositorio jpa_cliente;

    @Override
    public void agregarEntidad(Cliente c) {
        jpa_cliente.save(c);
    }

    @Override
    public List<Cliente> getListaEntidad() {
        return jpa_cliente.findAll();
    }

    @Override
    public Cliente getEntidad(String id) {
        return jpa_cliente.findById(id).orElse(null);
    }

    @Override
    public void editarEntidad(Cliente c) {
        Cliente c_bbdd=jpa_cliente.findById(c.getUser_cli()).orElse(null);
        if(c_bbdd!=null){
            c_bbdd.setPass_cli(c.getPass_cli());
            c_bbdd.setDni_cli(c.getDni_cli());
            c_bbdd.setApe_cli(c.getApe_cli());
            c_bbdd.setNom_cli(c.getNom_cli());
            c_bbdd.setPass_cli(c.getPass_cli());
            c_bbdd.setCorreo_cli(c.getCorreo_cli());
        }
    }

    @Override
    public void eliminarEntidad(String id) {
        jpa_cliente.deleteById(id);
    }
}
