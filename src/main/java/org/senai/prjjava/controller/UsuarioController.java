package org.senai.prjjava.controller;
import java.util.Optional;

import org.senai.prjjava.entity.Usuario;
import org.senai.prjjava.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.QAbstractAuditable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//http://localhost:8080/api/usuario/add?nome=Mariana&email=marigmmarques@gmail.com -- NESSE EXEMPLOS SÃO USADOS VARIÁVEIS DE PARÂMETRO chave=valor
@Controller 
@RequestMapping(path="/api/usuario") 
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private UsuarioRepository uRepository;
    
    @PostMapping("/")
    public @ResponseBody Integer addUsuario(@RequestBody Usuario objU ){
        uRepository.save(objU);
        return objU.getId();
    }

    @GetMapping ("/")
    public @ResponseBody Iterable<Usuario> buscarUsuarios(){
        return uRepository.findAll();
    }
    //http://localhost:8080/api/usuario/2 - NESSE EXEMPLO É USADO UMA VARIÁVEL PATH
    @GetMapping("/{id}")
    public @ResponseBody Optional<Usuario> buscarUsuario(@PathVariable Integer id){
        return uRepository.findById(id);
    }

    @PutMapping("/")
    public @ResponseBody Usuario atualizar(@RequestBody Usuario objU){
        uRepository.save(objU);
        return objU;
    }

    @DeleteMapping("/")
    public @ResponseBody String apagar(@PathVariable Integer id){
        uRepository.deleteById(id);
        return "Apagado";
    }
}
