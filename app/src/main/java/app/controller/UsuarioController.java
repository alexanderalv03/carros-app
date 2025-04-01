package app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.service.UsuarioService;

@RestController
@RequestMapping("api/usuario")
@CrossOrigin("*")
public class UsuarioController {

    private UsuarioService usuarioService;

}
