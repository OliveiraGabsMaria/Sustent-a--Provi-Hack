package br.com.sustentae.Sustentae.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O campo não deve conter valor nulo ou espaço vazio")
	@Size(min = 1, max = 100, message = "É necessário colocar o nome min 1 e max 100")
	private String empresa;
	
	@Schema(example = "email@email.com.br")
	@NotNull(message = "O campo não deve conter valor nulo ou espaço vazio")
	@Email
	private String usuario;
	
	@NotBlank(message = "O campo não deve conter valor nulo ou espaço vazio")
	@Size(min = 6, message = "É necessário colocar uma senha no min 6")
	private String senha;
	
	private String foto;
	
	@JsonIgnoreProperties("usuario")
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	private List<DadosModel> dados;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<DadosModel> getDados() {
		return dados;
	}

	public void setDados(List<DadosModel> dados) {
		this.dados = dados;
	}
	
	
}
