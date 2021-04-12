package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		List<String> res = new ArrayList<>();
		Anagramma model = new Anagramma();
		res.addAll(model.permutazioni("banca"));
		System.out.println(res);

	}

}
