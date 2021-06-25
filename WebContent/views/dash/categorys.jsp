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
                                        
                                    
                                    <div class="easion-card-title"><i class="fas fa-table"></i> Categorys</div>
                                    </div></div>
                                    
                                     
                                    <div class="col">
                                <div class="float-right">
                                 <a href="${pageContext.request.contextPath}/Admin?page=addcat" class="btn btn-primary"><i class="fas fa-plus"></i> Ajouter</a>
                                 </div>
                               </div>
                               </div>
                                </div>
                                <div class="card-body ">
                                    <table class="table table-striped table-in-card">
                                        <thead>
                                            <tr>
                                                <th scope="col">#</th>
                                                <th scope="col">Category name</th>
                                                <th scope="col">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${listCategory}" var="categorie">
                                            <tr>
                                                <th scope="row"><c:out value="${categorie.id}" /> </th>
                                                <td> <c:out value="${categorie.nom}" /> </td>                                                
                                                <td>
                                                <a href="${pageContext.request.contextPath}/Admin?page=onecat&lang=${categorie.id}"><i class="fas fa-edit"></i></a> 
                                                <a href="${pageContext.request.contextPath}/Admin?page=removecat&lang=${categorie.id}"  onclick="return confirm('Vous Volulez Suprimer la categorie : ${categorie.nom} ?')"><i class="far fa-trash-alt"></i></a>
                                                </td>
                                            </tr>
										</c:forEach>
	                                    </tbody>
                                    </table>
                                  
                                </div>
</div>