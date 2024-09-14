package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping(value = "/flores")
public class FlorController {

    @GetMapping("/listar")
    public String listarFlores(){

        return "flores";

    }

    @GetMapping("/registrar")
    public String registrarFlores(){

        return "regflores";
    }
}
