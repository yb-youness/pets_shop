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
import com.beans.Categorie;
import com.beans.Produits;
import com.db.Conn;
import com.mysql.cj.jdbc.Blob;


public class CategorysOps {

	
	private static String Insert_Cat ="INSERT INTO categories VALUES (default,?);";
	   
	   
	public void Add_Cat(Categorie cat) {
	    try(Connection con = Conn.getConnection()){
	    	PreparedStatement pr =con.prepareStatement(Insert_Cat);
	    	pr.setString(1, cat.getNom());
	    	pr.executeUpdate();
	 	
	    	
	    }catch (SQLException e) {
		    e.printStackTrace();
		}
		


	}
	
	
	
	
	
	
	
	
	 public List<Categorie> list() {
	        List<Categorie> listCategory = new ArrayList<Categorie>();
	         
	        try (Connection con = Conn.getConnection()) {
	            String sql = "SELECT * FROM categories";
	            PreparedStatement stm = con.prepareStatement(sql);
	            ResultSet result = stm.executeQuery(sql);
	             
	            while (result.next()) {
	            	 Categorie categorie = new Categorie();
	            	 categorie.setId(result.getInt("categorieID"));
	            	 categorie.setNom(result.getString("name"));
	            	 
	            	 listCategory.add(categorie);

	            }          
	             
	        } catch (SQLException ex) {
	            ex.printStackTrace();

	        }      
	         
	        return listCategory;
	    }
	
	
	
	
	
	
	 public void delete(int idcat) {
		  String Delete ="DELETE FROM categories WHERE categorieID=?"; 
   	    try(Connection con = Conn.getConnection()){
   	   PreparedStatement pr = con.prepareStatement(Delete);
   	   pr.setInt(1, idcat);
   	   pr.executeUpdate();
   	
   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		
	}
	
	 public void updateCat(Categorie cat) {
	      String Query="UPDATE categories set name=? where categorieID=? ";
		   try(Connection con = Conn.getConnection()){
			   PreparedStatement pr = con.prepareStatement(Query);
			  
		    	pr.setString(1,cat.getNom() );
		     	pr.setInt(2,cat.getId() );

		    	pr.executeUpdate();
	        }
		   catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
	    }
	
	
	 public Categorie OneCat(int c) throws SQLException, IOException {
		 Categorie cat=null;
	        try (Connection con = Conn.getConnection()) {
	            String select = "SELECT categorieID,name from categories where categorieID=? ";
	            PreparedStatement stm = con.prepareStatement(select);
	            stm.setInt(1,c);
	            ResultSet result = stm.executeQuery();
	            while (result.next()) {
		         int id = result.getInt("categorieID");
	                String nom =result.getString("name");
	                        
	                //Set values
	                cat = new Categorie(id,nom);
		     
	            }     
	            
	             
	        } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}      
	         
	        return cat;
	    }


	
}
