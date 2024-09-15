package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.entidad.Empleado;
import com.example.demo.modelo.entidad.Producto;
import com.example.demo.seguridad.Encriptar;
import com.example.demo.servicio.BoletaInformacionServicio;
import com.example.demo.servicio.BoletaServicio;
import com.example.demo.servicio.ClienteServicio;
import com.example.demo.servicio.EmpleadoServicio;
import com.example.demo.servicio.ProductoServicio;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    // @Autowired
    // private PersonRespository jpa_person;

    @Autowired
    public EmpleadoServicio empleado_servicio;

    @Autowired
    public BoletaServicio boleta_servicio;

    @Autowired
    public ClienteServicio cliente_servicio;

    @Autowired
    public ProductoServicio producto_servicio;

    @Autowired
    public BoletaInformacionServicio bi_servicio;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        agregarProducto();
        //ejecicios();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Empleado e=new Empleado("Jose", "1234", "12345678", "Jose Silvera", "Romani","vendedor", 2500.0, dateFormat.parse("2003-05-15"), "Av. Abancay 382", null);
        empleado_servicio.agregarEntidad(e);
        //System.out.println(Encriptar.encriptar("Juan123"));
        //System.out.println(Encriptar.encriptar("juan123"));
        //System.out.println(Encriptar.desencriptar(Encriptar.encriptar("Juan123")));
    }

    public void agregarProducto() {
        ArrayList<Producto> productos = new ArrayList<>();
        // Agregar los datos proporcionados a la lista
        
        productos.add(new Producto("T001", "Telefono", "iPhone 13", 1200.0, 50, "https://imagedelivery.net/4fYuQyy-r8_rpBpcY7lH_A/falabellaPE/18673460_8/w=800,h=800,fit=pad", null));
        productos.add(new Producto("T002", "Telefono", "Samsung A13", 1500.0, 30, "https://imagedelivery.net/4fYuQyy-r8_rpBpcY7lH_A/falabellaPE/121116996_01/w=800,h=800,fit=pad", null));
        productos.add(new Producto("T003", "Telefono", "Samsung A12", 400.0, 20, "https://imagedelivery.net/4fYuQyy-r8_rpBpcY7lH_A/falabellaPE/135574204_01/w=800,h=800,fit=pad", null));
        productos.add(new Producto("T004", "Tablet", "Samsung XPS", 700.0, 40, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWw5RlfsfMGM_8qx2F1M1fr69XpwgCmNux6A&s", null));
        productos.add(new Producto("T005", "Tablet", "Galaxy Tab S7", 300.0, 60, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkIHnp0Lfhccep95lhhB2EjRf03Duhn8BVPg&s", null));
        productos.add(new Producto("T006", "Tablet", "Galaxy Tab S6", 3500.0, 15, "https://http2.mlstatic.com/D_NQ_NP_2X_769158-MLU75968351070_052024-T.webp", null));
        productos.add(new Producto("T007", "Impresora", "Pad X9, Pad 8", 600.0, 25, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFixiCvfP0Tw72eeLBASu37DIziAdoI-MQTQ&s", null));
        productos.add(new Producto("T008", "Impresora", "Canon PIXMA TS5351", 150.0, 50, "https://thumbs.ielectro.es/product/med/24108-1.webp", null));
        productos.add(new Producto("T009", "Impresora", "Epson EcoTank ET-2812", 70.0, 40, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJJrUe7MQJeu_69NeH-meSBplQ8ZuRdNPfsQ&s", null));
        productos.add(new Producto("T010", "Impresora", "Epson EcoTank ET-4760", 400.0, 30, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQM4W2k49YHEoCm5vbkbK5pQFcFqDK11Wd87g&s", null));
        productos.add(new Producto("T011", "Impresora", "HP OfficeJet 200 Mobile", 200.0, 35, "https://promart.vteximg.com.br/arquivos/ids/7318560-444-444/image-11.jpg?v=638249784593530000", null));
        productos.add(new Producto("T012", "Tablet", "Asus RT-AX88U", 300.0, 28, "https://m.media-amazon.com/images/I/61XjJnKEeJL._AC_UF894,1000_QL80_.jpg", null));
        productos.add(new Producto("T013", "Tablet", "Seagate Backup Plus", 100.0, 45, "https://http2.mlstatic.com/D_NQ_NP_698369-MLA47755623046_102021-O.webp", null));
        productos.add(new Producto("T014", "Smart TV", "The Terrace.", 800.0, 10, "https://i.ytimg.com/vi/CkECzQEemhk/maxresdefault.jpg", null));
        productos.add(new Producto("T015", "Smart TV", "BenQ HT2050A", 700.0, 20, null, null));
        productos.add(new Producto("T016", "Smart TV", "Sony UBP-X800M2", 250.0, 30, null, null));
        productos.add(new Producto("T017", "Smart TV", "The Frame", 1200.0, 15, null, null));
        productos.add(new Producto("T018", "Smart TV", "Neo QLED.", 200.0, 25, null, null));
        productos.add(new Producto("T019", "Impresora", "Anker PowerCore 26800", 50.0, 50, null, null));
        productos.add(new Producto("T020", "Impresora", "Canon PIXMA MG2550S", 600.0, 12, null, null));
        productos.add(new Producto("T021", "Impresora", "Brother DCP1610W", 3000.0, 8, null, null));

        // Insertar los productos de tecnología en la base de datos (usando tu lógica)
        productos.stream().forEach(t -> {
            producto_servicio.agregarEntidad(t);
        });
    }
    public void ejecicios(){
        //Filtrar productos por categoría:
        /*List<Producto> nuebo=producto_servicio.getListaEntidad().stream().filter(
            t -> t.getCat_pro().equals("Tablet")
            ).collect(Collectors.toList());
        nuebo.forEach(t -> System.out.println(t.toString2()));*/

        //Obtener el promedio de precios de los productos:
        //System.out.println(producto_servicio.getListaEntidad().stream().mapToDouble(Producto::getPre_pro).average().orElse(0));
        
        //Obtener el promedio de precios de los producto de la categoria 'Impresora'
        /*System.out.println("Promedio 'Impresora':"+producto_servicio.getListaEntidad().stream().filter(t -> {
          return t.getCat_pro().equals("Impresora");
        }).mapToDouble(Producto::getPre_pro).average().orElse(0));*/

        //Obtener el promedio de precios de los producto de la categoria 'Telefono'
        /*System.out.println("Promedio 'Telefono':"+producto_servicio.getListaEntidad().stream().filter(t -> {
            return t.getCat_pro().equals("Telefono");
        }).mapToDouble(Producto::getPre_pro).average().orElse(0));*/

        //Obtener el promedio de precios de los producto de la categoria 'Smart TV'
        System.out.println("Promedio de SMART TV "+producto_servicio.getListaEntidad().stream().filter(t->{
            return t.getCat_pro().equals("Smart TV");
        }).mapToDouble(Producto::getPre_pro).average().orElse(0));
    }
}
