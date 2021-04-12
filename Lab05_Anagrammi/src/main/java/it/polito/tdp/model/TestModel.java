package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		List<String> res = new ArrayList<>();
		Model model = new Model();
		res.addAll(model.anagrammi("dog"));
		System.out.println(res);
		

	}

}
