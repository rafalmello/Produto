package apiSpriingboot.Produto.service;

import apiSpriingboot.Produto.model.Produto;
import apiSpriingboot.Produto.produtoReposytory.RepositoryProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class ServiceProduto {

    @Autowired
    private RepositoryProduto repositoryProduto;
    public Produto salvarProduto(Produto produto){
        return repositoryProduto.save(produto);
    }
    public List<Produto> listarProdutos(){
        return repositoryProduto.findAll();
    }

    public Optional <Produto> buscarProduto(Long Codigo){
        return repositoryProduto.findById(Codigo);
    }

    public Produto alterarProduto(Long codigo,Produto produto) {
        return repositoryProduto.save(produto);
    }

    public void excluirProduto(Long Codigo){
       repositoryProduto.deleteById(Codigo);
    }

    }




