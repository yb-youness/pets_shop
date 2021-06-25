package com.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.beans.Produits;
import com.db.Conn;
import com.mysql.cj.jdbc.Blob;

public class ProductsOps {
	 //DISPLAY ALL PRODUCTS pagination   
	 public List<Produits> listProductPaginate(int page,int recordsPerPage)  {
	        List<Produits> listProd = new ArrayList<>();
	        try (Connection con = Conn.getConnection()) {
	            String select = "SELECT ProduitId,catID,name,nom,image,description,prix,quantite,couleur from produit inner join categories on produit.catID=categories.categorieID ORDER BY this_date desc LIMIT ? , ?";
	            PreparedStatement stm = con.prepareStatement(select);
	            stm.setInt(1, page); // the page Num 
			    stm.setInt(2, recordsPerPage); // The num of record to display per page 
	            ResultSet result = stm.executeQuery();
	            while (result.next()) {
		         int id = result.getInt("produitID");
	                String nomcat=result.getString("name");
	                String nomProduit = result.getString("nom");
	                String description = result.getString("description");
	                double price = result.getDouble("prix");
	                int quantite = result.getInt("quantite");
	                String couleur = result.getString("couleur");
	                Blob fileraw= (Blob) result.getBlob("image");
			         InputStream inputStream = fileraw.getBinaryStream();
			         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			         byte[] buffer = new byte[4096];
			         int bytesRead = -1;
			          
			         while ((bytesRead = inputStream.read(buffer)) != -1) {
			             outputStream.write(buffer, 0, bytesRead);
			         }
			          
			         byte[] imageBytes = outputStream.toByteArray();
			          
			         String base64Image = Base64.getEncoder().encodeToString(imageBytes);
			          
			         inputStream.close();
			         outputStream.close();
	                
	                //Set values
		         Produits prod  = new Produits(id,nomcat,nomProduit,base64Image,description,price,quantite,couleur);
		         listProd.add(prod);
	            }     
	            
	             
	        } catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}      
	         
	        return listProd;
	    }
	 
	 
	 // All NO Pagination 
	 
	 public List<Produits> listProduct()  {
	        List<Produits> listProd = new ArrayList<>();
	        try (Connection con = Conn.getConnection()) {
	            String select = "SELECT ProduitId,catID,name,nom,image,description,prix,quantite,couleur from produit inner join categories on produit.catID=categories.categorieID ORDER BY this_date desc";
	            PreparedStatement stm = con.prepareStatement(select);
	            ResultSet result = stm.executeQuery();
	            while (result.next()) {
		         int id = result.getInt("produitID");
	                String nomcat=result.getString("name");
	                String nomProduit = result.getString("nom");
	                String description = result.getString("description");
	                double price = result.getDouble("prix");
	                int quantite = result.getInt("quantite");
	                String couleur = result.getString("couleur");
	                Blob fileraw= (Blob) result.getBlob("image");
			         InputStream inputStream = fileraw.getBinaryStream();
			         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			         byte[] buffer = new byte[4096];
			         int bytesRead = -1;
			          
			         while ((bytesRead = inputStream.read(buffer)) != -1) {
			             outputStream.write(buffer, 0, bytesRead);
			         }
			          
			         byte[] imageBytes = outputStream.toByteArray();
			          
			         String base64Image = Base64.getEncoder().encodeToString(imageBytes);
			          
			         inputStream.close();
			         outputStream.close();
	                
	                //Set values
		         Produits prod  = new Produits(id,nomcat,nomProduit,base64Image,description,price,quantite,couleur);
		         listProd.add(prod);
	            }     
	            
	             
	        } catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}      
	         
	        return listProd;
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 //INSERT
		public void insert(Produits p) {
			String add = "INSERT INTO produit VALUES (default,?,?,?,?,?,?,?,default)";
			   try(Connection con = Conn.getConnection()){
			    	PreparedStatement pr =con.prepareStatement(add);
			    	pr.setInt(1,p.getIdCat() );
			    	pr.setString(2,p.getNom() );
			    	pr.setBlob(3,p.getFile() );
			    	pr.setString(4,p.getDescription() );
			    	pr.setDouble(5,p.getPrix());
			    	pr.setInt(6,p.getQuantite() );
			    	pr.setString(7,p.getCouleur());
			    	pr.executeUpdate();			    	
			    }catch (SQLException e) {
				    e.printStackTrace();
				}
		} 
		
		
		public void delete(int idprod) {
			  String Delete ="DELETE FROM produit WHERE ProduitId=?"; 
	    	    try(Connection con = Conn.getConnection()){
	    	   PreparedStatement pr = con.prepareStatement(Delete);
	    	   pr.setInt(1, idprod);
	    	   pr.executeUpdate();
	    	
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
		}
		
		 public void updateProd(Produits p) {
		      String Query="UPDATE produit set catID=?,nom=?,image=?,description=?,prix=?,quantite=?,couleur=? where ProduitId=? ";
			   try(Connection con = Conn.getConnection()){
				   PreparedStatement pr = con.prepareStatement(Query);
				   	pr.setInt(1,p.getIdCat() );
			    	pr.setString(2,p.getNom() );
			    	pr.setBlob(3,p.getFile() );
			    	pr.setString(4,p.getDescription() );
			    	pr.setDouble(5,p.getPrix());
			    	pr.setInt(6,p.getQuantite() );
			    	pr.setString(7,p.getCouleur());
			    	pr.setInt(8,p.getId());

			    	pr.executeUpdate();
		        }
			   catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      
		    }
		
	 

	 
	 

		 public Produits OneProduct(int p) throws SQLException {
			 Produits produit=null;
		        try (Connection con = Conn.getConnection()) {
		            String select = "SELECT ProduitId,catID,name,nom,image,description,prix,quantite,couleur from produit inner join categories on produit.catID=categories.categorieID where ProduitId=? ";
		            PreparedStatement stm = con.prepareStatement(select);
		            stm.setInt(1,p);
		            ResultSet result = stm.executeQuery();
		            while (result.next()) {
			         int id = result.getInt("produitID");
		                String nomcat=result.getString("name");
		                String nomProduit = result.getString("nom");
		                String description = result.getString("description");
		                double price = result.getDouble("prix");
		                int quantite = result.getInt("quantite");
		                String couleur = result.getString("couleur");
		                Blob fileraw= (Blob) result.getBlob("image");
				         InputStream inputStream = fileraw.getBinaryStream();
				         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				         byte[] buffer = new byte[4096];
				         int bytesRead = -1;
				          
				         while ((bytesRead = inputStream.read(buffer)) != -1) {
				             outputStream.write(buffer, 0, bytesRead);
				         }
				          
				         byte[] imageBytes = outputStream.toByteArray();
				          
				         String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				          
				         inputStream.close();
				         outputStream.close();
		                
		                //Set values
				         produit = new Produits(id,nomcat,nomProduit,base64Image,description,price,quantite,couleur);
			     
		            }     
		            
		             
		        } catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}      
		         
		        return produit;
		    }

}
