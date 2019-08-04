package main.java.com.flux.candidatos.viewmodel;

import com.candidato.domain.Candidato;

public class CandidatoViewModel {

	private final Integer dni;
	private final String nombre;
	private final String apellido;
	private final String errMsj;

	//@formatter:off
	public CandidatoViewModel(Candidato candidato) {
		this.dni = candidato.getDni() != 0 ? candidato.getDni() : null;

		this.nombre = candidato.getNombre();
		this.apellido = candidato.getApellido();
		this.errMsj = candidato.getErrMsj();
	}

	public Integer getDni() { return this.dni; }
	public String getNombre() { return this.nombre; }
	public String getApellido() { return this.apellido; }
	public String getErrMsj() { return this.errMsj; }

}
