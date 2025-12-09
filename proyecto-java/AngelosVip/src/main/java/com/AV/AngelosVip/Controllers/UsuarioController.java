package com.AV.AngelosVip.Controllers;

import com.AV.AngelosVip.models.Rol;
import com.AV.AngelosVip.models.Usuario;
import com.AV.AngelosVip.service.RolService;
import com.AV.AngelosVip.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/registro")
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
        model.addAttribute("roles", rolService.listar());
        return "AdminEmpleado/Usuarios";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "AdminEmpleado/Usuarios";
    }

    @PostMapping("/guardar")
    public String guardar(Usuario usuario, RedirectAttributes redirect) {
        Usuario usuarioExistente = null;
        if (usuario.getIdUsuarios() != null) {
            usuarioExistente = usuarioService.buscarPorId(usuario.getIdUsuarios());
            if (usuarioExistente == null) {
                redirect.addFlashAttribute("error", "Usuario no encontrado");
                return "redirect:/registro";
            }
            // actualizar campos
            usuarioExistente.setNombreUsuarios(usuario.getNombreUsuarios());
            usuarioExistente.setEmail(usuario.getEmail());
            usuarioExistente.setRol(rolService.buscarPorId(usuario.getRol().getIdroles()));
            usuarioService.guardar(usuarioExistente);
        } else {
            // es un usuario nuevo
            if (usuarioService.buscarPorEmail(usuario.getEmail()) != null) {
                redirect.addFlashAttribute("error", "El correo ya está registrado");
                return "redirect:/registro";
            }
            usuario.setRol(rolService.buscarPorId(usuario.getRol().getIdroles()));
            usuarioService.guardar(usuario);
        }

        return "redirect:/registro?success=true";
    }


    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Usuario usuario = usuarioService.buscarPorId(id);
        if (usuario == null) {
            return "redirect:/registro?error=not_found";
        }
        model.addAttribute("usuario", usuario);
        return "AdminEmpleado/editarUsuarios";
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
