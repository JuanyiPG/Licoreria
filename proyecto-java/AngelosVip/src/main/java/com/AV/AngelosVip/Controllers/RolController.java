package com.AV.AngelosVip.Controllers;

import com.AV.AngelosVip.models.Rol;
import com.AV.AngelosVip.service.RolService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/Rol")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    // ----------------------------------------------------------
    // LISTAR ROLES
    // ----------------------------------------------------------
    @GetMapping()
    public String index(Model model) {

        List<Rol> roles = rolService.listar();

        model.addAttribute("roles", roles);     // tabla
        model.addAttribute("rol", new Rol());   // formulario

        return "AdminEmpleado/Rol";
    }

    // ----------------------------------------------------------
    // NUEVO ROL
    // ----------------------------------------------------------
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("rol", new Rol());
        return "AdminEmpleado/Rol";
    }

    // ----------------------------------------------------------
    // GUARDAR ROL (crear y actualizar)
    // ----------------------------------------------------------
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Rol rol, RedirectAttributes redirect) {

        Rol rolExistente = null;

        // Si tiene id → es edición
        if (rol.getIdroles() != null) {
            rolExistente = rolService.buscarPorId(rol.getIdroles());

            if (rolExistente == null) {
                redirect.addFlashAttribute("error", "Rol no encontrado");
                return "redirect:/Rol";
            }

            rolExistente.setNombrerol(rol.getNombrerol());

            rolService.guardar(rolExistente);

        } else {
            // Nuevo rol
            rolService.guardar(rol);
        }

        return "redirect:/Rol?success=true";
    }

    // ----------------------------------------------------------
    // EDITAR
    // ----------------------------------------------------------
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {

        Rol rol = rolService.buscarPorId(id);

        if (rol == null) {
            return "redirect:/Rol?error=not_found";
        }

        model.addAttribute("rol", rol);

        return "AdminEmpleado/editarRol";
    }

    // ----------------------------------------------------------
    // BUSCAR
    // ----------------------------------------------------------
    @GetMapping("/buscar")
    public String buscar(@RequestParam(name = "filtro", required = false) String filtro, Model model) {

        List<Rol> roles;

        if (filtro == null || filtro.isEmpty()) {
            roles = rolService.listar();
        } else {
            roles = rolService.buscarvarioscampos(filtro);
        }

        model.addAttribute("roles", roles);
        model.addAttribute("rol", new Rol());
        model.addAttribute("filtro", filtro);

        return "AdminEmpleado/Rol";
    }

    // ----------------------------------------------------------
    // ELIMINAR
    // ----------------------------------------------------------
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {

        rolService.eliminar(id);

        return "redirect:/Rol?deleted=true";
    }
}
