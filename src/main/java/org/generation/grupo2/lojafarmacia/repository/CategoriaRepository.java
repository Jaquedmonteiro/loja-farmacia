package org.generation.grupo2.lojafarmacia.repository;

import java.util.List;

import org.generation.grupo2.lojafarmacia.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	public List<Categoria> findAllByNomeCatContainingIgnoreCase(String nomeCat);

}
