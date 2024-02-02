package com.maxi.ecommerce.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maxi.ecommerce.models.DetalleOrden;
import com.maxi.ecommerce.models.Orden;
import com.maxi.ecommerce.models.Producto;
import com.maxi.ecommerce.models.Usuario;
import com.maxi.ecommerce.services.producto.ProductoServiceIMplementation;
import com.maxi.ecommerce.services.usuario.UsuarioServiceImplementation;

@Controller
@RequestMapping("/")
public class HomeController {
    private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ProductoServiceIMplementation productoService;

    @Autowired
    private UsuarioServiceImplementation usuarioService;

    private List<DetalleOrden> detalles = new ArrayList<DetalleOrden>();

    private Orden orden = new Orden();

    @GetMapping("/")
    public String home(Model model,
            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "8") int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        model.addAttribute("productos", productoService.findAll(page));
        return "usuario/home";
    }

    @GetMapping("/detalle/{id}")
    public String detalleProducto(@PathVariable Integer id, Model model) {
        Producto producto = new Producto();
        Optional<Producto> productoDB = productoService.get(id);
        producto = productoDB.get();
        model.addAttribute("producto", producto);
        return "usuario/detalle_producto";
    }

    @PostMapping("/cart")
    public String addToCart(@RequestParam Integer id, @RequestParam Integer cantidad, Model model) {
        DetalleOrden detalleOrden = new DetalleOrden();
        Producto producto = new Producto();
        double sumTotal = 0;

        Optional<Producto> productoDB = productoService.get(id);
        producto = productoDB.get();

        detalleOrden.setCantidad(cantidad);
        detalleOrden.setNombre(producto.getNombre());
        detalleOrden.setPrecio(producto.getPrecio());
        detalleOrden.setTotal(producto.getPrecio() * cantidad);
        detalleOrden.setProducto(producto);

        // filtrar producto repetido en la lista
        Integer idProducto = producto.getId();
        boolean existe = detalles.stream().anyMatch(x -> x.getProducto().getId() == idProducto);
        if (!existe) {
            detalles.add(detalleOrden);
        }

        sumTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

        orden.setTotal(sumTotal);

        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);
        // LOGGER.info("Id selecionado y el producto correspondiente: {} {}", id,
        // producto);

        return "usuario/carrito";
    }

    @GetMapping("/delete/cart/{id}")
    public String deleteProductFromCatr(@PathVariable Integer id, Model model) {

        List<DetalleOrden> listaOrdenes = new ArrayList<DetalleOrden>();

        for (DetalleOrden detalleOrden : detalles) {
            if (detalleOrden.getProducto().getId() != id) {
                listaOrdenes.add(detalleOrden);
            }
        }
        detalles = listaOrdenes;
        double sumTotal = 0;
        sumTotal = detalles.stream().mapToDouble(x -> x.getTotal()).sum();

        orden.setTotal(sumTotal);

        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);

        return "usuario/carrito";
    }

    @GetMapping("/ver/carrito")
    public String verCarrito(Model model) {
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);

        return "usuario/carrito";
    }

    @GetMapping("/detalle/orden")
    public String verdetelleOrden(Model model) {

        Usuario usuario = usuarioService.findById(1).get();
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);
        model.addAttribute("usuario", usuario);
        return "usuario/detalle_orden";
    }
}
