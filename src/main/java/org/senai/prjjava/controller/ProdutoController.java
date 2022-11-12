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

//http://localhost:8080/api/produto
@Controller
@RequestMapping(path="/api/produto")
@CrossOrigin("*")
public class ProdutoController {
    @Autowired
    private ProdutoRepository pRepository;
    //Adicinando novos produtos
    @PostMapping("/")
    public @ResponseBody Integer addproduto(@RequestBody Produto objP){
        pRepository.save(objP);
        return objP.getId();
    }
    //Buscando todos os produtos
    @GetMapping ("/")
    public @ResponseBody Iterable<Produto> buscarProdutos(){
        return pRepository.findAll();
    }
    //Buscando produto por ID
    @GetMapping("/{id}")
    public @ResponseBody Optional<Produto> buscarProduto(@PathVariable Integer id){
        return pRepository.findById(id);
    }
    //Alterando um produto
    @PutMapping("/")
    public @ResponseBody Produto atualizar(@RequestBody Produto objP){
        pRepository.save(objP);
        return objP;
    }
    //Deletando um prodduto
    @DeleteMapping("/{id}")
    public @ResponseBody String apagar(@PathVariable Integer id){
        pRepository.deleteById(id);
        return "Produto Apagado da Listagem";
    }
}