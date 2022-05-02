package br.com.sustentae.Sustentae.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_dados")
public class DadosModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O atributo mês é obrigatório")
	@Size(min = 4, message = "O atributo deve conter no mínimo 4 caracteres")
	private String mes;
	
	@NotNull(message = "O atributo kW é obrigatório")
	@Size(min = 2, message = "O atributo deve conter no mínimo 3 caracteres")
	private double kw;
	
	@NotNull(message = "O atributo Agua é obrigatório")
	@Size(min = 2, message = "O atributo deve conter no mínimo 2 caracteres")
	private double agua;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne
	@JsonIgnoreProperties("dados")
	private UsuarioModel usuario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public double getKw() {
		return kw;
	}

	public void setKw(double kw) {
		this.kw = kw;
	}

	public double getAgua() {
		return agua;
	}

	public void setAgua(double agua) {
		this.agua = agua;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	
}
