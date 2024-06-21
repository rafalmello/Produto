package apiSpriingboot.Produto.produtoReposytory;

import apiSpriingboot.Produto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProduto extends JpaRepository<Produto,Long> {
}
