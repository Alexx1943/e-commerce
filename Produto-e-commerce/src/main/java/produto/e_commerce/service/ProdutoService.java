package produto.e_commerce.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import produto.e_commerce.domain.Produto;
import produto.e_commerce.repository.ProdutoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;


    public List<Produto> findAll(){

        return repository.findAll();
    }

    public List<Produto> findByName(String name){

        return repository.findByName(name);
    }

    public Produto findById(Long id){

       return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto not found"));
    }

    public Produto save(Produto produto){

        return repository.save(produto);
    }

    public void update(Produto produto){

        var byId = findById(produto.getIdProduto());

        save(produto);
    }

    public  void deleteById(Long id){

        repository.deleteById(id);
    }
}
