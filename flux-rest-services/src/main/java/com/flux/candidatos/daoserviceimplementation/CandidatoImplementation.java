package main.java.com.flux.candidatos.daoserviceimplementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.candidato.dao.CandidatoDao;
import com.candidato.domain.Candidato;
import com.candidato.service.CandidatoService;

import utils.CommonResponse;
import utils.exceptions.EmptyValueException;

@Component("candidatoImplementationFlux")
public class CandidatoImplementation implements CandidatoService {

	@Autowired
	private CandidatoDao dao;

	private static final String connectionErrMsj = "Tenemos problemas de conexión, por favor intente mas tarde";

	@Override
	public Set<Integer> getCandidatosId(int dni) {
		Set<Integer> result = new HashSet<>();
		this.getCandidatos(dni).forEach(v -> result.add(v.getId()));
		return result;
	}

	// _______________________________________________________________

	@Override
	public Set<Integer> getCandidatosId(String nombre, String apellido) {
		Set<Integer> result = new HashSet<>();
		this.getCandidatos(nombre, apellido).forEach(v -> result.add(v.getId()));
		return result;
	}

	// _______________________________________________________________

	@Override
	public Collection<Candidato> getCandidatos(int dni) {
		Collection<Candidato> result = new ArrayList<>();
		try {
			return dao.getCandidatos(dni);
		} catch (ClassNotFoundException | NamingException e) {
			e.printStackTrace();
			result.add(new Candidato(connectionErrMsj));

		} catch (EmptyValueException e) {
			e.printStackTrace();
			result.add(new Candidato(e.getMessage()));
		}

		return result;
	}

	// _______________________________________________________________

	@Override
	public Collection<Candidato> getCandidatos(String nombre, String apellido) {
		Collection<Candidato> result = new ArrayList<>();
		try {
			return dao.getCandidatos(nombre, apellido);
		} catch (ClassNotFoundException | NamingException e) {
			e.printStackTrace();
			result.add(new Candidato(connectionErrMsj));

		} catch (EmptyValueException e) {
			e.printStackTrace();
			result.add(new Candidato(e.getMessage()));
		}

		return result;
	}

	// _______________________________________________________________

	@Override
	public CommonResponse deleteCandidato(int id) {

		return dao.deleteCandidato(id);
	}

	// _______________________________________________________________

	//@formatter:off
	@Override
	public CommonResponse createCandidato(
				int dni,
				String nombre,
				String apellido,
				String fecNacim,
				String domicilio,
				Integer telefono,
				String email
			){
	//@formatter:on

		return dao.createCandidato(dni, nombre, apellido, fecNacim, domicilio, telefono, email);
	}

	// _______________________________________________________________

	//@formatter:off
	@Override
	public CommonResponse updateCandidato(
			int id,
			int dni,
			String nombre,
			String apellido,
			String fecNacim,
			String domicilio,
			Integer telefono,
			String email
		){
	//@formatter:on

		return dao.updateCandidato(id, dni, nombre, apellido, fecNacim, domicilio, telefono, email);
	}

}
