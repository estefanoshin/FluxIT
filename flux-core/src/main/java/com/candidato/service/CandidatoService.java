package com.candidato.service;

import java.util.Collection;
import java.util.Set;

import com.candidato.domain.Candidato;

import utils.CommonResponse;

public interface CandidatoService {

	public Set<Integer> getCandidatosId(int dni);

	public Set<Integer> getCandidatosId(String nombre, String apellido);

	public Collection<Candidato> getCandidatos(int dni);

	public Collection<Candidato> getCandidatos(String nombre, String apellido);

	public CommonResponse deleteCandidato(int id);

	//@formatter:off
	/**
	 * Aparentemente existen los DNI duplicados
	 */
	public CommonResponse createCandidato(
				int dni,
				String nombre,
				String apellido,
				String fecNacim,
				String domicilio,
				Integer telefono,
				String email );

	public CommonResponse updateCandidato(
			int id,
			int dni,
			String nombre,
			String apellido,
			String fecNacim,
			String domicilio,
			Integer telefono,
			String email );

}
