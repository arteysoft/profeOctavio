package edu.it.dto;

public class UsuarioDTO {
	public String id;
	public String nombre;
	public String password;
	public String role;
	
	public UsuarioDTO() {}
	
	public UsuarioDTO(String id, String nombre, String password, String role) {
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.role = role;
	}	
}
