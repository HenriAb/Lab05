package it.polito.tdp.db;

public class TestDAO {

	public static void main(String[] args) {
		
		AnagrammaDAO aDAO = new AnagrammaDAO();
		if(aDAO.isCorrect("abaco")) {
			System.out.println("presente");
		}
		else {
			System.out.println("assente");
		}
			

	}

}
