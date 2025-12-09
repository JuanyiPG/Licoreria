package com.AV.AngelosVip.Controllers;

import com.AV.AngelosVip.models.Licor;
import com.AV.AngelosVip.service.LicorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/Licor")
public class LicorController {

    private final LicorService licorService;

    public LicorController(LicorService licorService) {
        this.licorService = licorService;
    }

    // ----------------------------------------------------------
    // LISTAR LICORES
    // ----------------------------------------------------------
    @GetMapping()
    public String index(Model model) {

        List<Licor> licores = licorService.listar();

        model.addAttribute("licores", licores);            // tabla
        model.addAttribute("licor", new Licor());          // formulario

        return "AdminEmpleado/Licor";
    }

    // ----------------------------------------------------------
    // NUEVO LICOR
    // ----------------------------------------------------------
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("licor", new Licor());
        return "AdminEmpleado/Licor";
    }

    // ----------------------------------------------------------
    // GUARDAR LICOR
    // ----------------------------------------------------------
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Licor licor, RedirectAttributes redirect) {

        Licor licorExistente = null;

        // Si viene con ID, es edición
        if (licor.getIdLicor() != null) {
            licorExistente = licorService.buscarPorId(licor.getIdLicor());

            if (licorExistente == null) {
                redirect.addFlashAttribute("error", "Licor no encontrado");
                return "redirect:/Licor";
            }

            // Actualizar campos
            licorExistente.setNombreLicor(licor.getNombreLicor());
            licorExistente.setMarca(licor.getMarca());
            licorExistente.setPrecio(licor.getPrecio());
            licorExistente.setStockmin(licor.getStockmin());
            licorExistente.setStockmax(licor.getStockmax());

            licorService.guardar(licorExistente);

        } else {
            // Nuevo licor
            licorService.guardar(licor);
        }

        return "redirect:/Licor?success=true";
    }

    // ----------------------------------------------------------
    // EDITAR LICOR
    // ----------------------------------------------------------
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {

        Licor licor = licorService.buscarPorId(id);

        if (licor == null) {
            return "redirect:/Licor?error=not_found";
        }

        model.addAttribute("licor", licor);

        return "AdminEmpleado/editarLicor";
    }

    // ----------------------------------------------------------
    // BUSCAR (estructura solicitada)
    // ----------------------------------------------------------
    @GetMapping("/buscar")
    public String buscar(@RequestParam(name = "filtro", required = false) String filtro, Model model) {

        List<Licor> licores;

        if (filtro == null || filtro.isEmpty()) {
            licores = licorService.listar();
        } else {
            licores = licorService.buscarvarioscampos(filtro);
        }

        model.addAttribute("licores", licores);      // tabla
        model.addAttribute("licor", new Licor());    // formulario
        model.addAttribute("filtro", filtro);

        return "AdminEmpleado/Licor";
    }

    // ----------------------------------------------------------
    // ELIMINAR LICOR
    // ----------------------------------------------------------
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {

        licorService.eliminar(id);

        return "redirect:/Licor?deleted=true";
    }
}
