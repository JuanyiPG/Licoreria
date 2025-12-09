package com.AV.AngelosVip.Controllers;

import com.AV.AngelosVip.models.Factura;
import com.AV.AngelosVip.models.Usuario;
import com.AV.AngelosVip.service.FacturaService;
import com.AV.AngelosVip.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    // LISTAR TODAS LAS FACTURAS (orden ascendente)
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


    // GUARDAR FACTURA
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Factura factura, RedirectAttributes redirect) {
        Factura facturaExistente = null;

        // Si es una factura existente
        if (factura.getIdFactura() != null) {
            facturaExistente = facturaService.buscarPorId(factura.getIdFactura());
            if (facturaExistente == null) {
                redirect.addFlashAttribute("error", "Factura no encontrada");
                return "redirect:/factura";
            }
            // actualizar campos
            facturaExistente.setFecha(factura.getFecha());
            facturaExistente.setTotal(factura.getTotal());

            // cargar correctamente el usuario
            Usuario usuario = usuarioService.buscarPorId(factura.getUsuario().getIdUsuarios());
            if (usuario == null) {
                redirect.addFlashAttribute("error", "Usuario no encontrado");
                return "redirect:/factura";
            }
            facturaExistente.setUsuario(usuario);

            facturaService.guardar(facturaExistente);
        } else {
            // nueva factura
            Usuario usuario = usuarioService.buscarPorId(factura.getUsuario().getIdUsuarios());
            if (usuario == null) {
                redirect.addFlashAttribute("error", "Usuario no encontrado");
                return "redirect:/factura";
            }
            factura.setUsuario(usuario);
            facturaService.guardar(factura);
        }

        return "redirect:/factura?success=true";
    }



    // EDITAR FACTURA
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


    // BUSCAR FACTURAS (estructura solicitada)
    @GetMapping("/buscar")
    public String buscar(@RequestParam(name = "filtro", required = false) String filtro, Model model) {

        List<Factura> facturas;

        if (filtro == null || filtro.isEmpty()) {
            facturas = facturaService.listar(); // listar todas las facturas si no hay filtro
        } else {
            facturas = facturaService.allcampos(filtro); // filtrar por los campos deseados
        }

        model.addAttribute("facturas", facturas);          // lista de facturas para la tabla
        model.addAttribute("factura", new Factura());      // objeto para el formulario
        model.addAttribute("usuarios", usuarioService.listar()); // lista de usuarios si se necesita en formulario
        model.addAttribute("filtro", filtro);             // para mostrar el filtro ingresado

        return "AdminEmpleado/Factura";
    }



    // ELIMINAR FACTURA
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        facturaService.Eliminar(id);
        return "redirect:/factura?deleted=true";
    }
}
