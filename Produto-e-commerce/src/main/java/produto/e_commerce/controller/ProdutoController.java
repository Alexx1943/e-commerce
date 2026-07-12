package produto.e_commerce.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import produto.e_commerce.domain.Produto;
import produto.e_commerce.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {

        var response = service.findAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<Produto>> findByNme(@PathVariable String name) {

        var response = service.findByName(name);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/findById")
    public ResponseEntity<Produto> findbyId(@PathVariable Long id) {

        var response = service.findById(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {

        var response = service.save(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("update")
    public ResponseEntity<Void> update(@RequestBody Produto produto) {

        service.update(produto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
