package com.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Categorie;
import com.beans.Client;
import com.dao.UserOps;


public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserOps user_ops;
       @Override
    public void init() throws ServletException {
    
    	 user_ops = new UserOps();  

    	super.init();
    }
  
    public login() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		         
		 String page = request.getParameter("page").toLowerCase();
		 
		 	
	 		switch(page)
	 		{
	 		
	 		case "login":		
	          Check_login(request, response); // %60
	 		   break;
	 		  
	 		case "register":
	 			  register(request, response);  
		 		   break;   
	 		case "deconect":
	                 // Remove session  
	 			request.getSession().invalidate();
				response.sendRedirect(request.getContextPath()+"/shop?page=home");
		 		   break; 	   
	 		
	 		}
		   
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	protected void register(HttpServletRequest request, HttpServletResponse
			  response) throws ServletException, IOException {
			  
			  Client user =new Client();
			  user.setName(request.getParameter("name"));
			  user.setEmail(request.getParameter("email"));
			  user.setPassword(request.getParameter("password"));
			  user.setAdresse(request.getParameter("adresse"));
			  user.setCompany(request.getParameter("company"));
			  user.setPhone(request.getParameter("phone")); 
			  user.setRole(false);//par defaut le role user
			  
			  user_ops.Add_User(user);
			  
			  response.sendRedirect(request.getContextPath()+"/shop?page=home");
			  
			  }
	
	
	
	
	protected void Check_login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		
		Client user = new Client();
          user.setEmail(request.getParameter("email"));
          user.setPassword(request.getParameter("pass"));

        	     switch (user_ops.checkLogin(user)) {
				case 0:
					  // Not Valid Redirect Same page + Error   msg => Requier css Class
					  
					    response.sendRedirect("shop?page=myaccount&msg=error");
					    
					break;

				case 1:
					  // Normal User set session + redirect 
					 request.getSession().invalidate(); // Destroy Any Session
			    	 HttpSession sessionuser = request.getSession(true);
			    	 sessionuser.setAttribute("roole","Nuser");  // if you want to display name of the curent user add his name the session var
					response.sendRedirect(request.getContextPath()+"/shop?page=home");
					break;
				case 2:
					  // Super  User set session + redirect to dash bord 
					 request.getSession().invalidate(); // Destroy Any Session
			    	 HttpSession sessionadmin = request.getSession(true);
			    	 sessionadmin.setAttribute("roole", "admin");
					response.sendRedirect(request.getContextPath()+"/Admin?page=index");
					break;		
				}
				
		
	}
	
	
	
	
	
	protected void Fowrd(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException  {
		   String fullpath=	"views/petshop/"+path+".jsp";
		   RequestDispatcher rqd = request.getRequestDispatcher(fullpath);
	       rqd.forward(request, response);
		}

}
