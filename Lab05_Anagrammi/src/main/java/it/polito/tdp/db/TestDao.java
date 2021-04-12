package it.polito.tdp.db;

public class TestDao {

	public static void main(String[] args) {
		

		AnagrammaDAO aDAO = new AnagrammaDAO();
		if(aDAO.isCorrect("ab")) {
			System.out.println("Parola presente nel dizionario");
		}
		else {
			System.out.println("Parola assente nel dizionario");
		}
	}

}
