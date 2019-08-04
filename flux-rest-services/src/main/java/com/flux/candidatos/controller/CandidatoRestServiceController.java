package main.java.com.flux.candidatos.controller;

import java.util.ArrayList;
import java.util.Collection;

import com.candidato.domain.Candidato;

import main.java.com.flux.candidatos.viewmodel.CandidatoViewModel;

public abstract class CandidatoRestServiceController {

	public Collection<CandidatoViewModel> getCollection(Collection<Candidato> candidatos) {
		Collection<CandidatoViewModel> result = new ArrayList<>();
		if (candidatos != null) {
			candidatos.forEach(v -> result.add(new CandidatoViewModel(v)));
		}

		return result;
	}
}
