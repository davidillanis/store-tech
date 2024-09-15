package com.example.demo.controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.modelo.entidad.Boleta;
import com.example.demo.modelo.entidad.BoletaInformacion;
import com.example.demo.modelo.entidad.Cliente;
import com.example.demo.modelo.entidad.Empleado;
import com.example.demo.modelo.entidad.Producto;
import com.example.demo.servicio.BoletaInformacionServicio;
import com.example.demo.servicio.BoletaServicio;
import com.example.demo.servicio.ClienteServicio;
import com.example.demo.servicio.EmpleadoServicio;
import com.example.demo.servicio.ProductoServicio;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(path = { "/web" })
public class ControladorPrincipal {
    @Autowired
    private ProductoServicio productoServicio;
    @Autowired
    private BoletaServicio boletaServicio;
    @Autowired
    private BoletaInformacionServicio boletaInformacionServicio;
    @Autowired
    private EmpleadoServicio empleadoServicio;
    @Autowired
    private ClienteServicio clienteServicio;

    //el aux es para escojer y el cat_pro es para saber que categoria seleciono
    private int aux=0;
    private String cat_pro="";
    private List<Producto> productosAgregados;
    
    public ControladorPrincipal(){
        productosAgregados=new ArrayList<>();
    }
    
    @GetMapping(path = { "/index" })
    public ModelAndView index(HttpSession session) {
        List<Producto> nuevaLista = null;
        if(aux==0){
            nuevaLista=productoServicio.getListaEntidad();
        }if(aux==1){
            nuevaLista = productoServicio.getListaEntidad().stream().filter(t -> t.getCat_pro().toUpperCase().contains(cat_pro.toUpperCase())).collect(Collectors.toList());
        }
        ModelAndView model = new ModelAndView("index");
        if(session.getAttribute("user_cli")!=null){
            model.addObject("nombre", "session-"+session.getAttribute("user_cli"));
        }else if(session.getAttribute("user_emp")!=null){
            model.addObject("nombre", "session-"+session.getAttribute("user_emp"));
        }
        model.addObject("productos", nuevaLista);
        model.addObject("categorias", productoServicio.getListaEntidad().stream().map(Producto::getCat_pro).distinct().collect(Collectors.toList()));
        aux=0;
        return model;
    }
    //Para el buscador del la pagina, pasamos 'buscar' para que si mantenga el text al actualizar la pagina
    @PostMapping(path = {"/escojer"})
    public String escojerProducto(@RequestParam String buscar, Model model){
        List<Producto> nuevaLista = productoServicio.getListaEntidad().stream().filter(t -> t.getNom_pro().toUpperCase().contains(buscar.toUpperCase())).collect(Collectors.toList());        
        model.addAttribute("productos", nuevaLista);
        model.addAttribute("categorias", productoServicio.getListaEntidad().stream().map(Producto::getCat_pro).distinct().collect(Collectors.toList()));
        model.addAttribute("buscar", buscar);
        this.aux=0;
        return "index";
    }
    //filtro para las categorias
    @GetMapping(path = {"/categoria/{cat_pro}"})
    public String getEditarProducto(@PathVariable String cat_pro, Model model){
        this.aux=1;
        this.cat_pro=cat_pro;
        return "redirect:/web/index";
    }

    @GetMapping(path = {"/agregar/{cod_pro}"})
    public String agregarProducto(@PathVariable String cod_pro, HttpSession session){
        Producto p=productoServicio.getEntidad(cod_pro);
        if(!productosAgregados.contains(p)){
            p.setBoletaInformacions(null);
            productosAgregados.add(p);
            if(session.getAttribute("user_cli")!=null){
                session.setAttribute("productosAgregados", productosAgregados);
            }
        }
        return "redirect:/web/index";
    }
    @GetMapping(path = {"/carrito"})
    public ModelAndView carrito(HttpSession session) {
        ModelAndView model=new ModelAndView("carrito");
        model.addObject("productosAgregados", productosAgregados);
        return model;
    }
    @GetMapping(path = {"/quitar/{cod_pro}"})
    public String getQuitarProducto(@PathVariable String cod_pro, HttpSession session){
        Producto p=productoServicio.getEntidad(cod_pro);
        productosAgregados.remove(p);
        if(session.getAttribute("user_cli")!=null){
            session.setAttribute("productosAgregados", productosAgregados);
        }
        return "redirect:/web/carrito";
    }
    
    @GetMapping(path = {"/login"})
    public String login(Model model, HttpSession session) {
        model.addAttribute("cliente", new Cliente());
        if(session.getAttribute("user_emp")!=null){
            return "redirect:/pro/listar";
        }
        return "login";
    }

    @PostMapping(path = {"/comprar"})
    public String comprarProducto(@RequestParam int[] cantidad, HttpSession session){
    
        if(session.getAttribute("user_cli")!=null){
            Empleado e=empleadoServicio.getListaEntidad().get(0);//EMpleado por defecto_________________________________--
            Cliente c=clienteServicio.getEntidad(session.getAttribute("user_cli").toString());
            Boleta b=new Boleta(codigoBoleta(6), new Date(), e, c, null);
            boletaServicio.agregarEntidad(b);

            for(int i=0; i<productosAgregados.size(); i++){
                Producto p=productoServicio.getEntidad(productosAgregados.get(i).getCod_pro());
                boletaInformacionServicio.agregarEntidad(new BoletaInformacion(0, cantidad[i], b, p));
            }
            
            productosAgregados.clear();
            session.setAttribute("productosAgregados", productosAgregados);
            return "redirect:/web/index";
        }
        return "redirect:/web/login";
    }
    public String codigoBoleta(int cant) {
        String codigo = "B";
        for(int i=0; i<cant; i++){
            codigo+=(int)(Math.random()*10);
        }
        return codigo;
    }
}
