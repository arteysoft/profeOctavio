package edu.it.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	public String id;
    public String nombre;
    public String apellido;
    public String domicilio;
    public String pais;
    public Integer saldoCuenta;
}
