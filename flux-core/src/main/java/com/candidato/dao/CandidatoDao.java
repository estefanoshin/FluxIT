package com.candidato.dao;

import java.util.Collection;

import javax.naming.NamingException;

import org.springframework.stereotype.Repository;

import com.candidato.dao.queryexecutions.CandidatoQueryExecution;
import com.candidato.domain.Candidato;

import utils.CommonResponse;
import utils.exceptions.EmptyValueException;

@Repository
public class CandidatoDao extends CandidatoQueryExecution {

	public Collection<Candidato> getCandidatos(int dni) throws ClassNotFoundException, NamingException, EmptyValueException {

		String sql = "SELECT * FROM candidatos WHERE dni = ?;";

		return super.executeSelect(sql, new Object[] { dni });
	}

	public Collection<Candidato> getCandidatos(String nombre, String apellido) throws ClassNotFoundException, NamingException, EmptyValueException {

		String sql = "SELECT * FROM candidatos WHERE nombre = ? AND apellido = ?;";

		return super.executeSelect(sql, new Object[] { nombre, apellido });
	}

	public CommonResponse deleteCandidato(int id) {
		String sql = "delete from candidatos where id = ?";

		return super.executeUpdate(sql, new Object[] { id });
	}

	//@formatter:off
	public CommonResponse createCandidato(
			int dni,
			String nombre,
			String apellido,
			String fecNacim,
			String domicilio,
			Integer telefono,
			String email ){

		StringBuilder sql = new StringBuilder();
		sql.append("	INSERT INTO candidatos			");
		sql.append("	SET(							");
		sql.append("			id 			= 	?,		"); // null
		sql.append("			nombre 		= 	?,		");
		sql.append("			apellido 	= 	?,		");
		sql.append("			dni 		= 	?,		");
		sql.append("			fec_nacim 	= 	?,		");
		sql.append("			domicilio 	= 	?,		");
		sql.append("			telefono 	= 	?,		");
		sql.append("			email 		= 	?		");
		sql.append("		);							");

		return super.executeUpdate(sql.toString(), new Object[] {
				null, nombre, apellido, dni, fecNacim, domicilio, telefono, email
		});
	}

	public CommonResponse updateCandidato(
		int id,
		int dni,
		String nombre,
		String apellido,
		String fecNacim,
		String domicilio,
		Integer telefono,
		String email ){

		StringBuilder sql = new StringBuilder();
		sql.append("	UPDATE candidatos				");
		sql.append("	SET								");
		sql.append("			nombre 		=	?,		");
		sql.append("			apellido 	= 	?,		");
		sql.append("			dni 		=	?,		");
		sql.append("			fec_nacim 	= 	?,		");
		sql.append("			domicilio 	= 	?,		");
		sql.append("			telefono 	= 	?,		");
		sql.append("			email 		= 	?		");
		sql.append("	WHERE 							");
		sql.append("			id 			=	?;		");

		return super.executeUpdate(sql.toString(), new Object[] {
				nombre, apellido, dni, fecNacim, domicilio, telefono, email, id
		});
	}

}
