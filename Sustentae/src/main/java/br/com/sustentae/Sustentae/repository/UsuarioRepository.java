package br.com.sustentae.Sustentae.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sustentae.Sustentae.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{
	public Optional<UsuarioModel> findByUsuario (String usuario);
	
	public List<UsuarioModel> findAllByEmpresaContainingIgnoreCase(String empresa);
}
