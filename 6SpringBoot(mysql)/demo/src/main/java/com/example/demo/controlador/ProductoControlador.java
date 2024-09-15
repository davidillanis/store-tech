package com.example.demo.controlador;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.modelo.entidad.Producto;
import com.example.demo.servicio.ProductoServicio;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(path = { "/pro" })
public class ProductoControlador {
    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping(path = {"/", "/index"})
    public ModelAndView index() {
        ModelAndView model=new ModelAndView("index");
        return model;
    }
    

    @GetMapping(path = { "/listar" })
    public String listarProducto(Model model, HttpSession session) {
        if(session.getAttribute("user_emp")==null){
            return "redirect:/web/login";
        }
        List<Producto> productos = productoServicio.getListaEntidad();
        model.addAttribute("productos", productos);
        return "listar-productos";
    }

    @GetMapping(path = {"/nuebo"})
    public String agregarProducto(Model model, HttpSession session){
        if(session.getAttribute("user_emp")==null){
            return "redirect:/web/login";
        }
        model.addAttribute("producto", new Producto());
        model.addAttribute("accion", "/pro/nuebo-post");
        return "guardar-producto";
    }
    @PostMapping(path={"/nuebo-post"})
    public String guardarProducto(@ModelAttribute Producto p, @RequestParam("file") MultipartFile file, HttpServletRequest request){
        p.setCod_pro(codigoProducto(6));
        p.setUrl_pro(getUrlImage(file, request));
        productoServicio.agregarEntidad(p);

        return "redirect:/pro/listar";
    }


    @GetMapping(path = {"/editar/{cod_pro}"})
    public String getEditarProducto(@PathVariable String cod_pro, Model model, HttpSession session){
        if(session.getAttribute("user_emp")==null){
            return "redirect:/web/login";
        }
        Producto p=productoServicio.getEntidad(cod_pro);
        model.addAttribute("producto", p);
        model.addAttribute("accion", "/pro/editar-post/"+cod_pro);
        return "guardar-producto";
    }
    @PostMapping(path = {"/editar-post/{cod_pro}"})
    public String postEditarProducto(@PathVariable String cod_pro, @ModelAttribute Producto p, @RequestParam("file") MultipartFile file, HttpServletRequest request){
        p.setUrl_pro(getUrlImage(file, request));
        productoServicio.editarEntidad(cod_pro, p);
        return "redirect:/pro/listar";
    }


    @GetMapping(path = {"/eliminar/{cod_pro}"})
    public String getEliminarProducto(@PathVariable String cod_pro, HttpSession session){
        if(session.getAttribute("user_emp")==null){
            return "redirect:/web/login";
        }
        productoServicio.eliminarEntidad(cod_pro);
        return "redirect:/pro/listar";
    }
    
    public String getUrlImage(MultipartFile file, HttpServletRequest request){    
        String servidor=ServletUriComponentsBuilder.fromRequestUri(request).replacePath(null).build().toUriString();
        String capeta_img="/images/producto/";
        if(file.getOriginalFilename()!="" || file.getOriginalFilename()=="null"){
            //llevar al servidor la imagen
            String nombre_img=file.getOriginalFilename();
            String ruta=System.getProperty("user.dir")+"/demo/src/main/resources/static"+capeta_img+nombre_img;
            try {
                file.transferTo(new File(ruta));
            } catch (IllegalStateException | IOException e) {e.printStackTrace(); }

            //obtener el la direccion del servidor
            return servidor+capeta_img+nombre_img;
        }else{
            return servidor+capeta_img+"defecto.png";
        }
    }
    public String codigoProducto(int cant) {
        String codigo = "P";
        for(int i=0; i<cant; i++){
            codigo+=(int)(Math.random()*10);
        }
        return codigo;
    }
}
