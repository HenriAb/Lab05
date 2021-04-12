package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private TextArea txtOutputCorretti;

    @FXML
    private TextArea txtOutputErrati;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {

    	List<String> permutazioni = new ArrayList<>();
    	List<String> corrette = new ArrayList<>();
    	List<String> errate = new ArrayList<>();
    	String input = this.txtInput.getText();
    	
    	if(input.equals("") || input.matches("[0-9]")) {
    		this.txtOutputCorretti.setText("ERRORE! devi inserire solo lettere!");
    		this.txtOutputErrati.setText("ERRORE! devi inserire solo lettere!");
    		return;
    	}
    	
    	permutazioni = this.model.anagrammi(input);
    	if(permutazioni.size() != 0) {
//    		for(String s : permutazioni) {
//    			if(this.model.isCorrect(s)) {
//    				corrette.add(s);
//    			}
//    			else {
//    				errate.add(s);
//    			}
//    		}
    		
    	}
    	
    	//corrette = this.model.corrette
    	
    	/**/
    	//this.txtOutputCorretti.setText(this.model.getCorrette().toString());
    	//this.txtOutputErrati.setText(this.model.getErrate().toString());
    	
    	corrette = this.model.getCorrette();
    	errate = this.model.getErrate();
    	String cor = "";
    	String err = "";
    	for(String s : corrette ) {
    		cor += s + "\n";
    	}
    	for(String s : errate) {
    		err += s + "\n";
    	}
    	this.txtOutputCorretti.setText(cor);
    	this.txtOutputErrati.setText(err);
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	this.txtInput.clear();
    	this.txtOutputCorretti.clear();
    	this.txtOutputErrati.clear();

    }

    public void setModel(Model model) {
    	this.model = model;
    }
    
    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOutputCorretti != null : "fx:id=\"txtOutputCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOutputErrati != null : "fx:id=\"txtOutputErrati\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
