package com.AV.AngelosVip.Controllers;

import com.AV.AngelosVip.models.Factura;
import com.AV.AngelosVip.models.Usuario;
import com.AV.AngelosVip.service.FacturaService;
import com.AV.AngelosVip.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/factura")
public class FacturaController {

    private final FacturaService facturaService;
    private final UsuarioService usuarioService;

    public FacturaController(FacturaService facturaService, UsuarioService usuarioService) {
        this.facturaService = facturaService;
        this.usuarioService = usuarioService;
    }

    // ----------------------------------------------------------
    // LISTAR TODAS LAS FACTURAS (orden ascendente)
    // ----------------------------------------------------------
    @GetMapping()
    public String index(Model model) {
        List<Factura> facturas = facturaService.ordenAsc();
        model.addAttribute("facturas", facturas);
        model.addAttribute("factura", new Factura());
        model.addAttribute("usuarios", usuarioService.listar()); // para seleccionar usuario
        return "AdminEmpleado/Factura";
    }

    // ----------------------------------------------------------
    // NUEVA FACTURA (form vacio)
    // ----------------------------------------------------------
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("factura", new Factura());
        model.addAttribute("usuarios", usuarioService.listar());
        return "AdminEmpleado/Factura";
    }

    // ----------------------------------------------------------
    // GUARDAR FACTURA
    // ----------------------------------------------------------
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Factura factura) {

        // Cargar correctamente el usuario desde BD
        Usuario usuario = usuarioService.buscarPorId(factura.getUsuario().getId());
        factura.setUsuario(usuario);

        facturaService.guardar(factura);

        return "redirect:/factura?success=true";
    }

    // ----------------------------------------------------------
    // EDITAR FACTURA
    // ----------------------------------------------------------
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {

        Factura factura = facturaService.buscarPorId(id);
        if (factura == null) {
            return "redirect:/factura?error=not_found";
        }

        model.addAttribute("factura", factura);
        model.addAttribute("usuarios", usuarioService.listar());
        return "AdminEmpleado/editarFactura";
    }

    // ----------------------------------------------------------
    // BUSCAR FACTURAS (estructura solicitada)
    // ----------------------------------------------------------
    @GetMapping("/buscar")
    public String buscar(@RequestParam String filtro, Model model) {

        List<Factura> lista = facturaService.allcampos(filtro);

        model.addAttribute("facturas", lista);
        model.addAttribute("filtro", filtro);
        model.addAttribute("factura", new Factura());
        model.addAttribute("usuarios", usuarioService.listar());

        return "AdminEmpleado/Factura";
    }

    // ----------------------------------------------------------
    // ELIMINAR FACTURA
    // ----------------------------------------------------------
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        facturaService.Eliminar(id);
        return "redirect:/factura?deleted=true";
    }
}
