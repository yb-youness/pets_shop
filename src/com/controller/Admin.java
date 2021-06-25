package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.beans.Categorie;
import com.beans.Client;
import com.beans.Produits;
import com.dao.CategorysOps;
import com.dao.ProductsOps;
import com.dao.UserOps;
@MultipartConfig
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategorysOps categoryops;
	private ProductsOps prodOps;
	private UserOps userOps;
    public Admin() {
        super();
      
    }
    
    @Override
    public void init() throws ServletException {
    userOps=new UserOps();
    categoryops = new CategorysOps();  
    prodOps = new ProductsOps();
    	super.init();
    } 



	/**
	 *
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String page = request.getParameter("page").toLowerCase();
		 response.setHeader("Cache-Control","no-cache");
		 response.setHeader("Cache-Control","no-store");
		 response.setHeader("Pragma","no-cache");
		 response.setDateHeader("Expires", 0);
			if(request.getSession().getAttribute("roole")!=null && request.getSession().getAttribute("roole")=="admin") {
		 	
	 		switch(page)
	 		{
	 		
	 		case "addprod"://pour rederiger vers le formulaire addprod.jsp
	 	
		 	           List<Categorie> listCatagory = categoryops.list();
		 	           request.setAttribute("listCategory", listCatagory);	
		 	           Fowrd(request, response,"addprod");
		 	        
	 			break;
	 		
	 		case "newprod"://ajouter des nouveaux produits
	 			insertProd(request, response);
	 			break;
	 			
	 		case "removeprod":
	 			deleteprod(request, response);
	 			break;
	 			
	 		case "oneprod":
	 			//selectionner un seul produit afin de modifier
	 			int id = Integer.parseInt(request.getParameter("lang"));

			
				Produits produit=null;
				try {
					produit = prodOps.OneProduct(id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					 request.setAttribute("produit", produit);	//first attribute for products
					 List<Categorie> listCat = categoryops.list();
		 	           request.setAttribute("listCategory", listCat);	//second attribute for list category
					 Fowrd(request, response,"addprod"); 
			
				break;
		 	      
	 		case "editprod" :   
	 	      updateProd(request, response);
	 			break;
	
	 		case "listproduct" :
                   
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
					 Fowrd(request, response,"products"); 
	 	       
	 	 
	 		
	 			break;
	 		case "newcat":
	 			insertCatt(request, response);  
	 			
	
	 		   break;
	 		   
	 		case "onecat":
	 			//selectionner une seul categorie afin de modifier
	 			int id1 = Integer.parseInt(request.getParameter("lang"));

				try {
					 Categorie cat = categoryops.OneCat(id1);
					 request.setAttribute("cat", cat);	//first attribute for products
					 	//second attribute for list category
					 Fowrd(request, response,"addcat"); 
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
				
	 		case "editcat" :   
	 		 	updateCat(request, response);
		 			break;
		 			
	 		case "removecat":
	 			deletecat(request, response);
	 			break;
	 			
	 		case "listcategory":
	 			
	 	           List<Categorie> listCatago = categoryops.list();
	 	           request.setAttribute("listCategory", listCatago);	
	 	           Fowrd(request, response,"categorys");
	 	           
	 			break;
	  
	 		   
	 		case "listclient":
	 			
	 	           List<Client> listClient = userOps.list();
	 	           request.setAttribute("listClients", listClient);	
	 	           Fowrd(request, response,"clients");
	 	    
	 			break;
	 		case "removeclient":
	 			int id2=Integer.parseInt(request.getParameter("id"));
	 			userOps.delete(id2);
	 			response.sendRedirect(request.getContextPath()+"/Admin?page=listclient");
	 			break;
	  
	 		default:
	 		
	 			
			     Fowrd(request, response, page);
				break;  
	 		}
			}else 
				 response.sendRedirect(request.getContextPath()+"/shop?page=myaccount"); 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private void insertCatt(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		  Categorie cat =new Categorie(); 
		  cat.setNom(request.getParameter("name"));


		  categoryops.Add_Cat(cat);
		  
		  response.sendRedirect(request.getContextPath()+"/Admin?page=listcategory");
	}
	
	protected  void updateProd(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		Produits prod = new Produits();
		
		prod.setId( Integer.parseInt(request.getParameter("id")));
		prod.setNom(request.getParameter("name"));
		prod.setIdCat(Integer.parseInt(request.getParameter("category")));
		Part filepart = request.getPart("image");
		prod.setFile(filepart.getInputStream());
		prod.setDescription(request.getParameter("description"));
		prod.setPrix(Double.parseDouble(request.getParameter("prix")));
		prod.setQuantite(Integer.parseInt(request.getParameter("quantite")));
		prod.setCouleur(request.getParameter("couleur"));
		prodOps.updateProd(prod);
		response.sendRedirect(request.getContextPath()+"/Admin?page=listproduct");
		
	}
	
	
	
	protected  void insertProd(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		Produits prod = new Produits();
		prod.setNom(request.getParameter("name"));
		prod.setIdCat(Integer.parseInt(request.getParameter("category")));
		Part filepart = request.getPart("image");
		prod.setFile(filepart.getInputStream());
		prod.setDescription(request.getParameter("description"));
		prod.setPrix(Double.parseDouble(request.getParameter("prix")));
		prod.setQuantite(Integer.parseInt(request.getParameter("quantite")));
		prod.setCouleur(request.getParameter("couleur"));
		prodOps.insert(prod);
		 response.sendRedirect(request.getContextPath()+"/Admin?page=listproduct");
		
	}
	
	protected void  deleteprod(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		 	int id = Integer.parseInt(request.getParameter("lang"));
	        prodOps.delete(id);
	        response.sendRedirect(request.getContextPath()+"/Admin?page=listproduct");
		
	}
	
	
	protected void Fowrd(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException  {
	   String fullpath=	"views/dash/"+path+".jsp";
	   RequestDispatcher rqd = request.getRequestDispatcher(fullpath);
       rqd.forward(request, response);
	
		
	}
	
	
	protected  void updateCat(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		Categorie cat = new Categorie();
		
		
		cat.setId(Integer.parseInt(request.getParameter("idcat")));
		cat.setNom(request.getParameter("name"));
		
		categoryops.updateCat(cat);
		response.sendRedirect(request.getContextPath()+"/Admin?page=listcategory");
		
	}

	protected void  deletecat(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
	 	int id = Integer.parseInt(request.getParameter("lang"));
        categoryops.delete(id);
        response.sendRedirect(request.getContextPath()+"/Admin?page=listcategory");
	
}
}
