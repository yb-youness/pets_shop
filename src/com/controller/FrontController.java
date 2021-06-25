package com.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Categorie;
import com.beans.Produits;
import com.dao.CategorysOps;
import com.dao.ProductsOps;
import com.dao.UserOps;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.List;
import java.util.Properties;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserOps user_ops;
	private CategorysOps categoryops;
	private ProductsOps prodOps;
    public FrontController() {
        super();
        
    }
    @Override
  public void init() throws ServletException {
    	  categoryops = new CategorysOps();  
    	    prodOps = new ProductsOps();
  	 user_ops = new UserOps();  

  	super.init();
  } 

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   

	
		        
		
		 		
		 		  String page = request.getParameter("page").toLowerCase();
                 
                 	
		 		  
	 	          
	 	           
		 		switch(page)
		 		{
		 		
		 		case "home":
		 			int pa=1;
		 			 
			 		   int recordsPerPage = 3;  
			           if(request.getParameter("p") != null)
			               pa = Integer.parseInt(request.getParameter("p"));
			           int paging =(pa-1)*recordsPerPage; // Calculate the limt
			             // This To display records
			           List<Produits> listproducts = prodOps.listProductPaginate(paging,recordsPerPage);
			 		    /// Calculate the num of page 
			           int noOfRecords = prodOps.listProduct().size(); // count of records
			           int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage); // Calculate the num of page 
			           
			           
			           request.setAttribute("noOfPages", noOfPages);
			           request.setAttribute("currentPage", pa);
			 	           request.setAttribute("listproducts", listproducts);	
							
		 			Fowrd(request, response,"home");
		 	           
		 			break;
		 			
		 		case "setlang":
		 	      // Change The Lang 
		 		  String lang = request.getParameter("lang");
		 		 Cookie ck=new Cookie("curentlang",URLEncoder.encode(lang,"UTF-8"));
		     	  response.addCookie(ck);
		 		   response.sendRedirect(request.getHeader("referer")); //  send To the prev Url 
		 		   break;
		 		   
		 		case "sendmail":
			 	      // Envoi d email 
		 			     // To do sucsess message + validation 
			 		  String name = request.getParameter("name");
			 		  String email = request.getParameter("email");
			 		  String phone = request.getParameter("phone");
			 		  String company = request.getParameter("company");
			 		  String  message = request.getParameter("message");
			 		   String content ="<h1>  From:"+email+"</h1>"+
			 				           "<h2>  Phone :"+phone+"</h2>"+
			 				            "<h3> Company :"+company+"</h3>"+
			 				            "<p> Company :"+message+"</p>";
			 		   sendMailhtml(request, response,email, content,"?page=contact&suc=true");
			 		                    
			 		   break; 
		 		
		 		   
		 		default:
		 			
		 			
				     Fowrd(request, response, page);
					break;  
		 		}
		         
		        
		  
		 
		
	}

	
	
	
	
	protected void Fowrd(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException  {
	   String fullpath=	"views/petshop/"+path+".jsp";
	   RequestDispatcher rqd = request.getRequestDispatcher(fullpath);
	   List<Categorie> listCatago = categoryops.list();
        request.setAttribute("listCategory", listCatago);	
	   rqd.forward(request, response);
	   
		
	}
	
	
	private void sendMailhtml(HttpServletRequest request, HttpServletResponse response ,String from,String content,String redirect) throws ServletException, IOException  {
		 
		
			// Activate less Secure App To Send Email Using SMTP (Gmail Server ) =>       https://myaccount.google.com/security
			 String username = "ecomercnet@gmail.com"; // Change this
	         String password = "Azerty101010";          // Change This
	        Properties prop = new Properties();
	        prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "587");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.starttls.enable", "true"); //TLS
	        
	        Session session = Session.getInstance(prop,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });

	        try {
	        	

	            Message message = new MimeMessage(session);
	            
	        
	            
	            message.setFrom(new InternetAddress(from)); // Sender this wont work  hardcode the email in the content
	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse("ecomercnet@gmail.com") // Reciver 
	            );
	            message.setSubject("Sujet"); // Subject
	            message.setContent(content,"text/html");  // Content
	            Transport.send(message);

	              // Redirect or Fowrd 
	                 // If redriect Use Session or msgMethod
	              response.sendRedirect(request.getContextPath()+"/shop"+redirect);
	               

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
    }
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
