<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="includes/head.jsp" %>
<body>
<div class="dash">
<%@ include file="includes/nav.jsp" %>
                                 <div class="container">
                                <div class="row">
                               <div class="col">
                                
                                <div class="card-header">
                                    <div class="easion-card-icon">

                                    <div class="easion-card-title"><i class="fas fa-table"></i> Produits</div>
                                    </div></div>
                                    </div>
                                    </div>
                                     <div class="card easion-card">
                                <div class="card-header">
                                    <div class="easion-card-icon">
                                        <i class="fas fa-chart-bar"></i>
                                    </div> <c:if test="${produit != null}">
                                    <div class="easion-card-title"> Edit Form </div>
                                    </c:if>
                                     <c:if test="${produit == null}">
                                    <div class="easion-card-title"> Add Form </div>
                                    </c:if>
                                </div>
                                <div class="card-body ">
                                  <c:if test="${produit != null}">
                            <form action="${pageContext.request.contextPath}/Admin?page=editprod"  enctype="multipart/form-data" method="post">
                        </c:if>
                        <c:if test="${produit == null}">
                            <form action="${pageContext.request.contextPath}/Admin?page=newprod" enctype="multipart/form-data"  method="post">
                        </c:if>
                                    
                                        <div class="form-group">
                                        <div class="form_row"> 
	 
                                         <c:if test="${produit != null}">
                          				  <input type="hidden" name="id"  value='${produit.id}' />
                       					 </c:if>			 
                                        			 
                                       
                                         <label for="exampleFormControlInput1">Produit Name</label>
                                            <input type="text" required="required"  value="${produit.nom}" class="form-control" id="exampleFormControlInput1" name="name" placeholder="Product name">
                                        </div>	 
                                           
                                             <div class="form_row"> 
                                             		
                                             <label for="id2" required="required" class="contact">Category</label><br>
                                             
									              		<select id="id2" name="category" >
									              		
														  		<c:forEach var="category" items="${listCategory}">  	
														  
														  					<option selected="selected" value="${category.id}">${category.nom}</option>
														  		
														    	</c:forEach>
														        																	   
			    										</select>
                                             </div>
                                              <div class="form_row">
                                               <label for="id3">Image</label>
                                            <input type="file" id="id3" required="required"  value="${produit.image}" class="form-control"  name="image">   
                                           
                                              </div>
                                              
                                                <div class="form_row">
                                               <label for="id4">Description</label>
                                            <input type="text" id="id4" required="required" value="${produit.description}" class="form-control"  name="description">   
                                           
                                              </div>
                                                <div class="form_row">
                                               <label for="id5">Prix</label>
                                            <input type="text" id="id5" required="required" class="form-control" value="${produit.prix}"  name="prix">   
                                           
                                              </div>
                                                <div class="form_row">
                                               <label for="id6">Quantite</label>
                                            <input type="number" id="id6" required="required" class="form-control"   value="${produit.quantite}" name="quantite">   
                                           
                                              </div>
                                              
                                                <div class="form_row">
                                               <label for="id7">Couleur</label>
                                            <input type="text" id="id7" required="required" class="form-control"  value="${produit.couleur}"   name="couleur">   
                                        </div>
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                    </form>
                                </div>
                            </div>
                             
</div>