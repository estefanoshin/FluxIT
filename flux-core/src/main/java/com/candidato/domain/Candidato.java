package com.candidato.domain;

import java.util.Date;

public class Candidato {

	private final int id;
	private final String nombre;
	private final String apellido;
	private final int dni;
	private final Date fecNacim;
	private final String domicilio;
	private final Integer telefono;
	private final String email;

	private String errMsj;

	public Candidato(String errMsj) {
		this(0, null, null, 0, null, null, null, null);
		this.errMsj = errMsj;
	}

	//@formatter:off
	public Candidato(
			int id,
			String nombre,
			String apellido,
			int dni,
			Date fecNacim,
			String domicilio,
			Integer telefono,
			String email) {

		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fecNacim = fecNacim;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.email = email;
	}

	// _____________________________

	public void setErrMsj(String errMsj) { this.errMsj = errMsj; }

	// _____________________________

	public String getErrMsj() { return this.errMsj; }
	public int getId() { return this.id; }
	public String getNombre() { return this.nombre; }
	public String getApellido() { return this.apellido; }
	public int getDni() { return this.dni; }
	public Date getFecNacim() { return this.fecNacim; }
	public String getDomicilio() { return this.domicilio; }
	public Integer getTelefono() { return this.telefono; }
	public String getEmail() { return this.email; }
	//@formatter:on

}
