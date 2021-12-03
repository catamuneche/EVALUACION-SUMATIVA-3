package com.nttdata3.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="usuarios")
public class Usuario {

	@Id //clave primaria o PK
	@GeneratedValue(strategy= GenerationType.IDENTITY)//auto incrementable
	private Long id;
	

	private String nombre;
	private String apellido;
	private String email;
	private String password;
	@Transient
	private String passwordConfirmation;
	
	
	//relacion many to many
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name="carritos",//tabla intermedia
		joinColumns = @JoinColumn(name="usuario_id"),
		inverseJoinColumns = @JoinColumn(name="producto_id")
	)
	private List<Producto> productos;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="roles_usuarios",//tabla intermedia
		joinColumns = @JoinColumn(name="usuario_id"),
		inverseJoinColumns = @JoinColumn(name="role_id")
	)
	private List<Role> roles;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	public Usuario(@NotNull @NotEmpty String nombre, String apellido, String email, String password,
			String passwordConfirmation) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
//		this.password = password;
//		this.passwordConfirmation = passwordConfirmation;
	}
	public Usuario() {
		super();
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


}
