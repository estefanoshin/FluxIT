package com.candidato.dao.queryexecutions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.management.InvalidAttributeValueException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.candidato.domain.Candidato;

import utils.CommonResponse;
import utils.ConnectionValues;
import utils.exceptions.EmptyValueException;

public class CandidatoQueryExecution extends ConnectionValues {

	protected Collection<Candidato> executeSelect(String sql, Object[] params) throws ClassNotFoundException, NamingException, EmptyValueException {
		Class.forName(MYSQL_DRIVER);
		Context envCtx = (Context) new InitialContext().lookup(ENVIRONMENT);
		DataSource dataSource = (DataSource) envCtx.lookup(PROPERTY);

		try (Connection conn = dataSource.getConnection()) {

			PreparedStatement st = conn.prepareStatement(sql);
			if (params.length == 1) {
				st.setInt(1, (int) params[0]);

			} else if (params.length == 2) {
				st.setString(1, (String) params[0]);
				st.setString(2, (String) params[1]);

			}

			ResultSet rs = st.executeQuery();

			Collection<Candidato> result = new ArrayList<>();

			//@formatter:off
			while (rs.next()) {
				result.add(new Candidato(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("apellido"),
						rs.getInt("dni"),
						rs.getDate("fec_nacim"),
						rs.getString("domicilio"),
						rs.getInt("telefono"),
						rs.getString("email")
						));
			}

			if (result.size() < 1) throw new EmptyValueException("No existen candidatos con los parámetros enviados");
			//@formatter:on

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new ArrayList<>();
	}

	// ______________________________________________________________________________________________
	// ______________________________________________________________________________________________

	protected CommonResponse executeUpdate(String sql, Object[] params) {
		DataSource dataSource = null;
		try {
			Class.forName(MYSQL_DRIVER);
			Context envCtx = (Context) new InitialContext().lookup(ENVIRONMENT);
			dataSource = (DataSource) envCtx.lookup(PROPERTY);
		} catch (ClassNotFoundException | NamingException e) {
			e.printStackTrace();
			return new CommonResponse(500, "Internal Server Error");
		}

		try (Connection conn = dataSource.getConnection()) {

			PreparedStatement st = conn.prepareStatement(sql);
			if (params.length == 1) {
				st.setInt(1, (int) params[0]);

			} else if (params.length == 8) {
				st.setString(1, (String) params[0]);
				st.setString(2, (String) params[1]);
				st.setString(3, (String) params[2]);
				st.setString(4, (String) params[3]);
				st.setString(5, (String) params[4]);
				st.setString(6, (String) params[5]);
				st.setString(7, (String) params[6]);
				st.setString(8, (String) params[7]);

			}

			//@formatter:off
			if(st.execute()) return new CommonResponse(200, "Acción realizada con éxito");

			//@formatter:on

			throw new InvalidAttributeValueException("Bad Request");

		} catch (SQLException e) {
			e.printStackTrace();
			return new CommonResponse(400, "Bad Request");

		} catch (InvalidAttributeValueException e) {
			e.printStackTrace();
			return new CommonResponse(400, e.getMessage());
		}

	}

}
