package com.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


import org.mindrot.jbcrypt.BCrypt;
import com.beans.Categorie;
import com.beans.Client;
import com.beans.Produits;
import com.db.Conn;
import com.mysql.cj.jdbc.Blob;




public class UserOps {
	// Check Login 
		public int checkLogin(Client user) {
			int status = 0;  // 0 dosent exsite  , 1 normal user , 2 admin  
			String Query ="SELECT count(*) ,password ,role FROM client WHERE email=?  ";
			 try(Connection con = Conn.getConnection()){
				 PreparedStatement stm = con.prepareStatement(Query);
				                   stm.setString(1, user.getEmail());
				                   
				  ResultSet rs = stm.executeQuery();          
				     while(rs.next()) {
				    	 if(rs.getInt("count(*)")==1) {
				    		  //Get the Pass as Raw to run the Check
				    		  String hashedP = rs.getString("password");
				    		  Boolean roole = rs.getBoolean("role");
				               /// Check For PassWord 
				    		 if(BCrypt.checkpw(user.getPassword(),hashedP)){
				    			 if(roole)
				    			  status=2;  // Admin
				    			 else
				    		     status=1; // Normal User
				    		 }     
				    	 }
				     }
				 				 
			 } catch (SQLException e) {
				
				e.printStackTrace();
			}
		
			return status;
		}
		
		
		
		private static String Insert_User ="INSERT INTO client VALUES (default,?,?,?,?,?,?,?);";
		   
		   
		public void Add_User(Client user) {
		    try(Connection con = Conn.getConnection()){
		    	PreparedStatement pr =con.prepareStatement(Insert_User);
		    	pr.setString(1, user.getName());
		    	pr.setString(2, user.getEmail());
		    	String passCrypt=BCrypt.hashpw(user.getPassword(),BCrypt.gensalt());
		    	pr.setString(3,passCrypt);
		    	pr.setString(4, user.getAdresse());
		    	pr.setString(5, user.getCompany());
		    	pr.setString(6, user.getPhone());
		    	pr.setBoolean(7, user.isRole());
		    	pr.executeUpdate();

		    }catch (SQLException e) {
			    e.printStackTrace();
			}

		}
	
		 
		 
		public List<Client> list() {
	        List<Client> listClient = new ArrayList<>();
	         
	        try (Connection con = Conn.getConnection()) {
	            String sql = "SELECT * FROM client";
	            PreparedStatement stm = con.prepareStatement(sql);
	            ResultSet result = stm.executeQuery(sql);
	             
	            while (result.next()) {
	            
	            	 int id=result.getInt("Id");
	            	 String name=result.getString("name");
	            		 String email=result.getString("email");
	            		 String password=result.getString("password");
	            		 String adresse=result.getString("adress");
	            		 String company=result.getString("company");
	            		 String phone=result.getString("phone");
	            		 Boolean role=result.getBoolean("role");
	            		 
	            		 Client client  = new Client(id,name,email,password,adresse,company,phone,role);
	            		 listClient.add(client);
	            		 
	            }          
	             
	        } catch (SQLException ex) {
	            ex.printStackTrace();

	        }      
	         
	        return listClient;
	    }
	public static void main(String[] args) {
		UserOps c=new UserOps();
		List<Client> cl=c.list();
		for(Client cm:cl){
			System.out.println(cm.toString());
		}
	}
	public void delete(int id) {
		  String Delete ="DELETE FROM client WHERE Id=?"; 
  	    try(Connection con = Conn.getConnection()){
  	   PreparedStatement pr = con.prepareStatement(Delete);
  	   pr.setInt(1, id);
  	   pr.executeUpdate();
  	
  } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		
	}

}
		
