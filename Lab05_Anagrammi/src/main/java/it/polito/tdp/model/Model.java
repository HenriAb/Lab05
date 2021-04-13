package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.db.AnagrammaDAO;

public class Model {
	
	AnagrammaDAO aDAO = new AnagrammaDAO();
	List<String> corrette = new ArrayList<>();
	List<String> errate = new ArrayList<>();
	List<String> res = new ArrayList<>();

	public List<String> anagrammi(String input){
			
	//	List<String> res = new ArrayList<>();
		permuta("", input, 0);
		return res;
	}
	
	private void permuta(String parziale, String lettere, int livello) {
		
		if(lettere.length() == 0) {
			if(this.isCorrect(parziale)) {
				corrette.add(parziale);
			}
			else {
				errate.add(parziale);
			}
			res.add(parziale);
			
		}
		else {
			for(int pos=0; pos<lettere.length(); pos++) {
				char tentativo = lettere.charAt(pos);
				
				String nuovaParziale = parziale + tentativo;
				String nuovaLettere = lettere.substring(0, pos) + lettere.substring(pos+1);
				
				// controllo nel dizionario
				permuta(nuovaParziale, nuovaLettere, livello++);
			}
		}
	}
	
	public boolean isCorrect(String anagramma) {
		return this.aDAO.isCorrect(anagramma);
	}
	
}
