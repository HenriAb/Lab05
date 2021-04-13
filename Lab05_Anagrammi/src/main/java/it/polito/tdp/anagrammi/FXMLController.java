package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.model.Anagramma;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Anagramma model;
	//List<String> res = new ArrayList<>();
	Set<String> res = new HashSet<>();
	
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
    void doCalcolaAnagramma(ActionEvent event) {

    	res.clear();
    	
    	String input = this.txtInput.getText();
    	
    	if(input.equals("") || input.matches(".*[0-9].*")) {
    		this.txtOutputCorretti.setText("Errore! Inserire solo lettere");
    		this.txtOutputErrati.setText("Errore! Inserire solo lettere");
    		return;
    	}
    	
    	List<String> corretti = new ArrayList<>();
    	List<String> errati = new ArrayList<>();
    	res = this.model.permutazioni(input);
    	
    	for(String s : res) {
    		if(this.model.isCorrect(s)) {
    			corretti.add(s);
    		}
    		else {
    			errati.add(s);
    		}
    	}
    	String cor = "";
    	String err = "";
    	for(String s : corretti) {
    		cor += s + "\n";
    	}
    	for(String s : errati){
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
    	this.res.clear();
    }

    public void setModel(Anagramma model) {
    	this.model = model;
    }
    
    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOutputCorretti != null : "fx:id=\"txtOutputCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOutputErrati != null : "fx:id=\"txtOutputErrati\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
