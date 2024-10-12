package com.example.demo.Controller;

import com.example.demo.Entities.Flor;
import com.example.demo.Service.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FlorController {

    @Autowired
    private FlorService florService;

    @GetMapping("/flores/listar")
    public String listarFlores(Model model) {
        List<Flor> flores = florService.findAll();
        model.addAttribute("flores", flores);
        return "flores";
    }

    @GetMapping("/flores/registrar")
    public String registrarFlores(Model model) {
        model.addAttribute("flor", new Flor());
        return "regflores";
    }

    @PostMapping("/flores/guardar")
    public String guardarFlor(@ModelAttribute Flor flor) {
        florService.save(flor);
        return "redirect:/flores/listar";
    }

    @GetMapping("/flores/eliminar/{id}")
    public String eliminarFlor(@PathVariable Long id) {
        florService.deleteById(id);
        return "redirect:/flores/listar";
    }

    @GetMapping("/flores/editar/{id}")
    public String editarFlor(@PathVariable Long id, Model model) {
        Flor flor = florService.findById(id);
        model.addAttribute("flor", flor);
        return "editflor";
    }

    @PostMapping("/flores/actualizar")
    public String actualizarFlor(@ModelAttribute Flor flor) {
        Flor existingFlor = florService.findById(flor.getId());
        if (existingFlor != null) {
            existingFlor.setNombre(flor.getNombre());
            existingFlor.setColor(flor.getColor());
            existingFlor.setVariedad(flor.getVariedad());
            existingFlor.setTipoDeFlor(flor.getTipoDeFlor());
            existingFlor.setCantidad(flor.getCantidad());
            existingFlor.setPrecioDeCompra(flor.getPrecioDeCompra());
            existingFlor.setPrecioDeVenta(flor.getPrecioDeVenta());
            florService.update(existingFlor);
        }
        return "redirect:/flores/listar";
    }

    @GetMapping("/floristeria/login")
    public String mostrarLogin() {
        return "login"; // Nombre del archivo login.html en templates
    }
}
