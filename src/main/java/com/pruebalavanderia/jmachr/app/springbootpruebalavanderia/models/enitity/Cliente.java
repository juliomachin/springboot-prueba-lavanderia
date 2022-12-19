package com.pruebalavanderia.jmachr.app.springbootpruebalavanderia.models.enitity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;
	
	@NotEmpty
	@Email
	private String email;

	@NotNull
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createAt;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Carro> carros;

    
	public Cliente() {
        carros = new ArrayList<Carro>();
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    public void addCarros(Carro carro){
        carros.add(carro);
    }

}

