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
@RequestMapping(value = "/flores")
public class FlorController {

    @Autowired
    private FlorService florService;

    @GetMapping("/listar")
    public String listarFlores(Model model) {
        List<Flor> flores = florService.findAll();
        model.addAttribute("flores", flores);
        return "flores";
    }

    @GetMapping("/registrar")
    public String registrarFlores(Model model) {
        model.addAttribute("flor", new Flor());
        return "regflores";
    }

    @PostMapping("/guardar")
    public String guardarFlor(@ModelAttribute Flor flor) {
        florService.save(flor);
        return "redirect:/flores/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFlor(@PathVariable Long id) {
        florService.deleteById(id);
        return "redirect:/flores/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarFlor(@PathVariable Long id, Model model) {
        Flor flor = florService.findById(id);
        model.addAttribute("flor", flor);
        return "editflor";
    }

    @PostMapping("/actualizar")
    public String actualizarFlor(@ModelAttribute Flor flor) {
    Flor existingFlor = florService.findById(flor.getId());
    if (existingFlor != null) {
        existingFlor.setNombre(flor.getNombre());
        existingFlor.setColor(flor.getColor());
        existingFlor.setPrecio(flor.getPrecio());
        florService.update(existingFlor);
    }
    return "redirect:/flores/listar";
}

}
