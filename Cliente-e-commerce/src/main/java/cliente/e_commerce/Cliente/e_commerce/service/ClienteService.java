package cliente.e_commerce.Cliente.e_commerce.service;

import cliente.e_commerce.Cliente.e_commerce.domain.Cliente;
import cliente.e_commerce.Cliente.e_commerce.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;


    public List<Cliente> findAll() {

        return repository.findAll();
    }

    public List<Cliente> findByName(String name){

        return repository.findByName(name);
    }

    public Cliente findById(Long id) {

        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Cliente save(Cliente cliente) {

        return repository.save(cliente);
    }

    public void update(Cliente cliente){

        var clienteToUpdate = findById(cliente.getId());

        save(cliente);
    }

    public void  delete(Long id){

        repository.deleteById(id);
    }
}

