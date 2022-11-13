package org.senai.prjjava.controller;

import java.util.Optional;

import org.senai.prjjava.entity.Produto;
import org.senai.prjjava.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

//http://localhost:8080/api/Produto/add?nome=Mariana&email=marigmmarques@gmail.com -- NESSE EXEMPLOS SÃO USADOS VARIÁVEIS DE PARÂMETRO chave=valor
@Controller
@RequestMapping(path = "/api/produto")
@CrossOrigin("*")
public class ProdutoController {
    @Autowired
    private ProdutoRepository pRepository;

    @PostMapping("/")
    public @ResponseBody Integer addProduto(@RequestBody Produto objU) {
        pRepository.save(objU);
        return objU.getId();
    }

    @GetMapping("/")
    public @ResponseBody Iterable<Produto> buscarProdutos() {
        return pRepository.findAll();
    }

    // http://localhost:8080/api/Produto/2 - NESSE EXEMPLO É USADO UMA VARIÁVEL PATH
    @GetMapping("/{id}")
    public @ResponseBody Optional<Produto> buscarProduto(@PathVariable Integer id) {
        return pRepository.findById(id);
    }

    @PutMapping("/")
    public @ResponseBody Produto atualizar(@RequestBody Produto objU) {
        pRepository.save(objU);
        return objU;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String apagar(@PathVariable Integer id) {
        pRepository.deleteById(id);
        return "Apagado";
    }
}
