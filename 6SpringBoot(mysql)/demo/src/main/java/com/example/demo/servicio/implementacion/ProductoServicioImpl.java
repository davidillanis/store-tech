package com.example.demo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.entidad.Producto;
import com.example.demo.modelo.repositorio.ProductoRepositorio;
import com.example.demo.servicio.ProductoServicio;

@Service
public class ProductoServicioImpl implements ProductoServicio{
    @Autowired
    private ProductoRepositorio jpa_producto;

    @Override
    public void agregarEntidad(Producto p) {
        jpa_producto.save(p);
    }

    @Override
    public List<Producto> getListaEntidad() {
        return jpa_producto.findAll();
    }

    @Override
    public Producto getEntidad(String id) {
        return jpa_producto.findById(id).orElse(null);
    }

    @Override
    public boolean editarEntidad(String id, Producto p) {
        Producto p_bbdd=jpa_producto.findById(id).orElse(null);
        if(p_bbdd!=null){
            p_bbdd.setCat_pro(p.getCat_pro());
            p_bbdd.setNom_pro(p.getNom_pro());
            p_bbdd.setPre_pro(p.getPre_pro());
            p_bbdd.setStock(p.getStock());
            p_bbdd.setUrl_pro(p.getUrl_pro());
            jpa_producto.save(p_bbdd);
            return true;
        }
        return false;
    }

    @Override
    public void eliminarEntidad(String id) {
        jpa_producto.deleteById(id);
    }    
}
