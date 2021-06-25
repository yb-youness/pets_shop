package com.beans;

import java.io.InputStream;

public class Produits {

	private int id;
	private String Libele;//libele categorie pour afficher les nom des categories dans la table produit
	private int idCat;//id categorie pour ajouter le cle etranger dans la table produit
	private String nom;
	private InputStream file;
	private String image;
	private String description;
	private double prix;
	private int quantite;
	private String couleur;
	
	public Produits() {}
	
	public Produits(int id,String Libele, String nom, String image, String description, double prix, int quantite,
			String couleur) {
		super();
		this.id = id;
		this.Libele=Libele;
		this.nom = nom;
		this.image = image;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.couleur = couleur;
	}
	
	
		
	public String getLibele() {
		return Libele;
	}

	public void setLibele(String libele) {
		Libele = libele;
	}

	public int getIdCat() {
		return idCat;
	}

	public void setIdCat(int idCat) {
		this.idCat = idCat;
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
	public InputStream getFile() {
		return file;
	}
	public void setFile(InputStream file) {
		this.file = file;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	
	  @Override
	public String toString() {
		return "Produits [id=" + id + ", idcat=" + idCat + ", Libele=" + Libele + ", nom=" + nom + ", file="
				+ file + ", image=" + image + ", description=" + description + ", prix=" + prix + ", quantite="
				+ quantite + ", couleur=" + couleur + "]";
	}

}
