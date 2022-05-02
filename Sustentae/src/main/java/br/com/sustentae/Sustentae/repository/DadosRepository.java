package br.com.sustentae.Sustentae.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sustentae.Sustentae.model.DadosModel;

@Repository
public interface DadosRepository extends JpaRepository<DadosModel, Long>{
	
	public List<DadosModel> findAllByMesContainingIgnoreCase(String mes);
}
