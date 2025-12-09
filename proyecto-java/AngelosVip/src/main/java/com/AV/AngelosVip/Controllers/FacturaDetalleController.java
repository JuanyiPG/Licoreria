package com.AV.AngelosVip.Controllers;

import com.AV.AngelosVip.models.Factura;
import com.AV.AngelosVip.models.FacturaDetalle;
import com.AV.AngelosVip.models.Licor;
import com.AV.AngelosVip.service.FacturaDetalleService;
import com.AV.AngelosVip.service.FacturaService;
import com.AV.AngelosVip.service.LicorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/factura-detalle")
public class FacturaDetalleController {

    private final FacturaDetalleService facturaDetalleService;
    private final FacturaService facturaService;
    private final LicorService licorService;

    public FacturaDetalleController(FacturaDetalleService facturaDetalleService,
                                    FacturaService facturaService,
                                    LicorService licorService) {
        this.facturaDetalleService = facturaDetalleService;
        this.facturaService = facturaService;
        this.licorService = licorService;
    }

    // LISTAR DETALLES
    @GetMapping()
    public String index(Model model) {

        List<FacturaDetalle> detalles = facturaDetalleService.listar();

        model.addAttribute("detalles", detalles);
        model.addAttribute("facturaDetalle", new FacturaDetalle());
        model.addAttribute("facturas", facturaService.listar());
        model.addAttribute("licores", licorService.listar());

        return "AdminEmpleado/FacturaDetalle";
    }

    // ----------------------------------------------------------
    // NUEVO DETALLE
    // ----------------------------------------------------------
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("detalle", new FacturaDetalle());
        model.addAttribute("facturas", facturaService.listar());
        model.addAttribute("licores", licorService.listar());
        return "AdminEmpleado/FacturaDetalle";
    }

    // ----------------------------------------------------------
    // GUARDAR DETALLE
    // ----------------------------------------------------------
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute FacturaDetalle detalle, RedirectAttributes redirect) {
        FacturaDetalle detalleExistente = null;

        // Si el detalle ya existe
        if (detalle.getIdFactDet() != null) {
            detalleExistente = facturaDetalleService.buscarPorId(detalle.getIdFactDet());
            if (detalleExistente == null) {
                redirect.addFlashAttribute("error", "Detalle no encontrado");
                return "redirect:/factura-detalle";
            }

            // actualizar campos
            detalleExistente.setLicor(detalle.getLicor());
            detalleExistente.setFactura(detalle.getFactura());

            // cargar correctamente la factura y el licor
            Factura factura = facturaService.buscarPorId(detalle.getFactura().getIdFactura());
            Licor licor = licorService.buscarPorId(detalle.getLicor().getIdLicor());

            if (factura == null) {
                redirect.addFlashAttribute("error", "Factura no encontrada");
                return "redirect:/factura-detalle";
            }
            if (licor == null) {
                redirect.addFlashAttribute("error", "Licor no encontrado");
                return "redirect:/factura-detalle";
            }

            detalleExistente.setFactura(factura);
            detalleExistente.setLicor(licor);

            facturaDetalleService.guardar(detalleExistente);

        } else {
            // es un nuevo detalle
            Factura factura = facturaService.buscarPorId(detalle.getFactura().getIdFactura());
            Licor licor = licorService.buscarPorId(detalle.getLicor().getIdLicor());

            if (factura == null) {
                redirect.addFlashAttribute("error", "Factura no encontrada");
                return "redirect:/factura-detalle";
            }
            if (licor == null) {
                redirect.addFlashAttribute("error", "Licor no encontrado");
                return "redirect:/factura-detalle";
            }

            detalle.setFactura(factura);
            detalle.setLicor(licor);

            facturaDetalleService.guardar(detalle);
        }

        return "redirect:/factura-detalle?success=true";
    }


    // ----------------------------------------------------------
    // EDITAR DETALLE
    // ----------------------------------------------------------
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {

        FacturaDetalle detalle = facturaDetalleService.buscarPorId(id);
        if (detalle == null) {
            return "redirect:/factura-detalle?error=not_found";
        }

        model.addAttribute("detalle", detalle);
        model.addAttribute("facturas", facturaService.listar());
        model.addAttribute("licores", licorService.listar());

        return "AdminEmpleado/editarFacturaDetalle";
    }

    // ----------------------------------------------------------
    // BUSCAR (estructura solicitada)
    // ----------------------------------------------------------
    @GetMapping("/buscar")
    public String buscar(@RequestParam(name = "filtro", required = false) String filtro, Model model) {

        List<FacturaDetalle> detalles;

        if (filtro == null || filtro.isEmpty()) {
            detalles = facturaDetalleService.listar();
        } else {
            detalles = facturaDetalleService.allcampos(filtro);
        }

        model.addAttribute("facturaDetalles", detalles);           // para la tabla
        model.addAttribute("facturaDetalle", new FacturaDetalle()); // para el formulario
        model.addAttribute("facturas", facturaService.listar());
        model.addAttribute("licores", licorService.listar());
        model.addAttribute("filtro", filtro);

        return "AdminEmpleado/FacturaDetalle";
    }


    // ----------------------------------------------------------
    // ELIMINAR
    // ----------------------------------------------------------
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        facturaDetalleService.Eliminar(id);
        return "redirect:/factura-detalle?deleted=true";
    }
}
