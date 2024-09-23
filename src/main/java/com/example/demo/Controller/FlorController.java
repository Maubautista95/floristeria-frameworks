package com.example.demo.Controller;

import com.example.demo.Entities.Flor;
import com.example.demo.Service.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String registrarFlores() {
        return "regflores";
    }
}
