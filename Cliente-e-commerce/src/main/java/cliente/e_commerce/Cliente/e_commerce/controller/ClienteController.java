package cliente.e_commerce.Cliente.e_commerce.controller;


import cliente.e_commerce.Cliente.e_commerce.domain.Cliente;
import cliente.e_commerce.Cliente.e_commerce.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {


    private final ClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {

        var response = service.findAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Cliente>> findByName(@PathVariable String name) {

        var response = service.findByName(name);

        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> findbyId(@PathVariable Long id) {

        var response = service.findById(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {

        var response = service.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Cliente cliente) {

        service.update(cliente);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }


}
