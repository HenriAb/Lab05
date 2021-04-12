package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.db.AnagrammaDAO;

public class Anagramma {
	
	AnagrammaDAO aDAO = new AnagrammaDAO();
//	private List<String> corrette = new ArrayList<>();
//	private List<String> errate = new ArrayList<>();
	private List<String> res = new ArrayList<>();
	
	public List<String> permutazioni(String parola){
		
		permuta("", parola, 0);
		return res;
	}
	
	private void permuta(String parziale, String lettere, int livello) {
		if(lettere.length() == 0) {
//			if(this.isCorrect(parziale)) {
//				corrette.add(parziale);
//			}
//			else {
//				errate.add(parziale);
//			}
			res.add(parziale);
		}
		else {
			for(int pos=0; pos<lettere.length(); pos++) {
				char tentativo = lettere.charAt(pos);
				
				String nuovaParziale = parziale + tentativo;
				String nuovaLettere = lettere.substring(0, pos) + lettere.substring(pos+1);
				
				permuta(nuovaParziale, nuovaLettere, livello+1);
			}
		}
	}
	
	public boolean isCorrect(String anagramma) {
		return this.aDAO.isCorrect(anagramma);
	}

//	public List<String> getCorrette() {
//		return corrette;
//	}
//
//	public List<String> getErrate() {
//		return errate;
//	}

}
