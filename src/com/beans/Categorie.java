package com.beans;

public class Categorie {
	
	@Override
	public String toString() {
		return "Categorie [nom=" + nom + "]";
	}
	private int id;
	private String nom;
	
	public Categorie(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	public Categorie() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	

}
