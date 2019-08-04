package main.java.com.flux.candidatos;

import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.candidato.service.CandidatoService;

import main.java.com.flux.candidatos.controller.CandidatoRestServiceController;
import main.java.com.flux.candidatos.viewmodel.CandidatoViewModel;
import utils.CommonResponse;

@RestController
@RequestMapping(value = "/candidatoRestService")
public class CandidatoRestService extends CandidatoRestServiceController {

	@Autowired
	@Qualifier("candidatoImplementationFlux")
	private CandidatoService service;

	@RequestMapping(value = "/getCandidatosId/{dni}", method = RequestMethod.GET)
	public @ResponseBody Set<Integer> getCandidatosId(@PathVariable("dni") int dni) {

		return service.getCandidatosId(dni);
	}

	// _______________________________________________________________

	//@formatter:off
			@RequestMapping(value = "/getCandidatosId/{nombre}/{apellido}", method = RequestMethod.GET)
			public @ResponseBody Set<Integer> getCandidatosId(
						@PathVariable("nombre") String nombre,
						@PathVariable("apellido") String apellido ) {

			return service.getCandidatosId(nombre, apellido);
		}
	//@formatter:on

	// _______________________________________________________________

	@RequestMapping(value = "/getCandidato/{dni}", method = RequestMethod.GET)
	public @ResponseBody Collection<CandidatoViewModel> getCandidato(@PathVariable("dni") int dni) {

		return super.getCollection(service.getCandidatos(dni));
	}

	// _______________________________________________________________

	//@formatter:off
		@RequestMapping(value = "/getCandidato/{nombre}/{apellido}", method = RequestMethod.GET)
		public @ResponseBody Collection<CandidatoViewModel> getCandidato(
					@PathVariable("nombre") String nombre,
					@PathVariable("apellido") String apellido ) {

		return super.getCollection(service.getCandidatos(nombre, apellido));
	}
	//@formatter:on

	// _______________________________________________________________

	@RequestMapping(value = "/deleteCandidato/{id}", method = RequestMethod.GET)
	public @ResponseBody CommonResponse deleteCandidato(@PathVariable("id") int id) {

		return service.deleteCandidato(id);
	}

	//@formatter:off
	@RequestMapping(value = "/createCandidato", method = RequestMethod.POST)
	public @ResponseBody CommonResponse createCandidato(
				@RequestParam(value = "dni", required = true) 			int dni,
				@RequestParam(value = "nombre", required = true) 		String nombre,
				@RequestParam(value = "apellido", required = true) 		String apellido,
				@RequestParam(value = "fecNacim", required = true) 		String fecNacim,
				@RequestParam(value = "domicilio", required = true) 	String domicilio,
				@RequestParam(value = "telefono", required = true) 		Integer telefono,
				@RequestParam(value = "email", required = true) 		String email ) {
		//@formatter:on

		return service.createCandidato(dni, nombre, apellido, fecNacim, domicilio, telefono, email);
	}

	// _______________________________________________________________

	//@formatter:off
	@RequestMapping(value = "/updateCandidato", method = RequestMethod.POST)
	public @ResponseBody CommonResponse updateCandidato(
				@RequestParam(value = "id", required = true) 			int id,
				@RequestParam(value = "dni", required = true) 			int dni,
				@RequestParam(value = "nombre", required = true) 		String nombre,
				@RequestParam(value = "apellido", required = true) 		String apellido,
				@RequestParam(value = "fecNacim", required = true) 		String fecNacim,
				@RequestParam(value = "domicilio", required = true) 	String domicilio,
				@RequestParam(value = "telefono", required = true) 		Integer telefono,
				@RequestParam(value = "email", required = true) 		String email ) {
		//@formatter:on

		return service.updateCandidato(id, dni, nombre, apellido, fecNacim, domicilio, telefono, email);
	}

}
