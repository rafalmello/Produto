package apiSpriingboot.Produto.controllerProduto;

import apiSpriingboot.Produto.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import apiSpriingboot.Produto.service.ServiceProduto;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ControllerProduto {
    @Autowired
    private ServiceProduto serviceProduto;

    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto){
        try {
            Produto produtoCriado = serviceProduto.salvarProduto(produto);
            return new ResponseEntity<>(produtoCriado, HttpStatus.CREATED);

        }catch (Exception exception){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        try {
            List<Produto> produtos = serviceProduto.listarProdutos();
            return new ResponseEntity<>(produtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Produto> buscarProdutoPorCodigo(@PathVariable Long codigo) {
        Optional<Produto> produto = serviceProduto.buscarProduto(codigo);
        return produto.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long codigo, @RequestBody Produto produto) {
        try {
            Produto produtoAtualizado = serviceProduto.alterarProduto(codigo, produto);
            return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<HttpStatus> deletarProduto(@PathVariable Long codigo) {
        try {
            serviceProduto.excluirProduto(codigo);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
