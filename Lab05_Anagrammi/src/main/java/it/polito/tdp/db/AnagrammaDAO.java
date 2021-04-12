package it.polito.tdp.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.model.Anagramma;

public class AnagrammaDAO {
	
	public boolean isCorrect(String anagramma) {
		
		String sql = "SELECT nome "
				+ "FROM parola "
				+ "WHERE nome = '?'";
		
		try {
			Connection conn = DBConnect.getConnection();
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(0, anagramma);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				conn.close();
				Anagramma a = new Anagramma(rs.getString("nome"), true);
				return true;
			}

		}catch(SQLException sqle) {
			//throw new RuntimeException();
			return false;
		}

		return false;
		
	}
	
}
