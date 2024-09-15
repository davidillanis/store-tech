package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.entidad.Cliente;
import com.example.demo.modelo.entidad.Empleado;
import com.example.demo.servicio.ClienteServicio;
import com.example.demo.servicio.EmpleadoServicio;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping(path = {"/cli"})
public class ClienteControloador {
    @Autowired
    private ClienteServicio clienteServicio;
    @Autowired
    private EmpleadoServicio empleadoServicio;

    @GetMapping(path = {"/list"})
    public List<Cliente> listarCliente(){
        return clienteServicio.getListaEntidad();
    }

    //Logica para el usuario(cliente, empleado) para la session
    @PostMapping(path = {"/session-post"})
    public String accederSession(@ModelAttribute Cliente c, HttpSession session) {
        Cliente c_bd=clienteServicio.getEntidad(c.getUser_cli());
        Empleado e_bd=empleadoServicio.getEntidad(c.getUser_cli());
        if(c_bd!=null && c_bd.getPass_cli().equals(c.getPass_cli())){
            session.setAttribute("user_emp", null);
            session.setAttribute("user_cli", c.getUser_cli());
            return "redirect:/web/index";
        }else if(e_bd!=null && e_bd.getPass_emp().equals(c.getPass_cli())){
            session.setAttribute("user_cli", null);
            session.setAttribute("user_emp", e_bd.getUser_emp());
            return "redirect:/pro/listar";
        }else{
            return "redirect:/web/login";
        }
    }
    @GetMapping(path = {"cerrar-session"})
    public String cerrarSession(HttpSession session){
        session.setAttribute("productosAgregados", null);
        if(session!=null){
            session.invalidate();
        }
        return "redirect:/web/index";
    }
}
