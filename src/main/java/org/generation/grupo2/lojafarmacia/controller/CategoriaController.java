package org.generation.grupo2.lojafarmacia.controller;

import java.util.List;

import org.generation.grupo2.lojafarmacia.model.Categoria;
import org.generation.grupo2.lojafarmacia.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {

    private @Autowired CategoriaRepository repository;

    // getAllCategoria
    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    // getByIdCategoria
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable (value = "id") Long id) {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
            .orElse(ResponseEntity.notFound().build());
    }

    // getByDescricaoCategoria
    @GetMapping("/nome/{name}")
    public ResponseEntity<List<Categoria>> getByName(@PathVariable (value = "name") String name) {
        return ResponseEntity.ok(repository.findAllByNomeCatContainingIgnoreCase(name));
    }

    // postCategoria
    @PostMapping
    public ResponseEntity<Categoria> post(@RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
    }

    // putCategoria
    @PutMapping
    public ResponseEntity<Categoria> put(@RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
    }

    // deleteCategoria
    @DeleteMapping("/{id}")
    public void delete(@PathVariable (value = "id") Long id) {
        repository.deleteById(id);
    }
}
