package com.AV.AngelosVip.Controllers;

import com.AV.AngelosVip.models.Rol;
import com.AV.AngelosVip.models.Usuario;
import com.AV.AngelosVip.service.RolService;
import com.AV.AngelosVip.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("Registro")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final RolService rolService;

    public UsuarioController(RolService rolService, UsuarioService usuarioService) {
        this.rolService = rolService;
        this.usuarioService = usuarioService;
    }

    @GetMapping()
    public String registro(Model model) {
        List<Usuario> usuarios = usuarioService.orden();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("rol", rolService.listar());
        return "AdminEmpleado/Usuarios";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "AdminEmpleado/Usuarios";
    }

    @PostMapping("/guardar")
    public String guardar(Usuario usuario) {
        Rol rolSeleccionado = rolService.buscarPorId(usuario.getRol().getId_roles());
        usuario.setRol(rolSeleccionado);
        usuarioService.guardar(usuario);
        return "redirect:registro?success=true";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Usuario usuario = usuarioService.buscarPorId(id);
        if (usuario == null) {
            return "redirect:/registro?error=not_found";
        }
        model.addAttribute("usuario", usuario);
        return "AdminEmpleado/editarUsuario";
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam(name = "buscar", required = false) String filtro, Model model) {
        List<Usuario> usuarios;
        if (filtro == null || filtro.isEmpty()) {
            usuarios = usuarioService.listar();
            model.addAttribute("usuarios", usuarios);
        } else {
            usuarios = usuarioService.buscarvarioscampos(filtro);
            model.addAttribute("usuarios", usuarios);
        }
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuario", usuarioService.listar());
        return "AdminEmpleado/Usuarios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        usuarioService.eliminar(id);
        return "redirect:/registrar?error=not_found";
    }
}
