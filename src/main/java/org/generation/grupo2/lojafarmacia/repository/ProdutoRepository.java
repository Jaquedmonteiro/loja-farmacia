package org.generation.grupo2.lojafarmacia.repository;

import java.util.List;

import org.generation.grupo2.lojafarmacia.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	public List<Produto> findAllByNameContainingIgnoreCase(String name);
	public List<Produto> findAllByFornecedorContainingIgnoreCase(String fornecedor);

}

