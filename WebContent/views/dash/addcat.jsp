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
                                    
                                    
                                    <div class="easion-card-title"><i class="fas fa-table"></i> Categorys</div>
                                    </div></div>
                                    </div>
                                    
                                    </div>
                                    
                                     <div class="card easion-card">
                                <div class="card-header">
                                    <div class="easion-card-icon">
                                        <i class="fas fa-chart-bar"></i>
                                    </div>
                                    <c:if test="${cat != null}">
                                    <div class="easion-card-title"> Edit Form </div>
                                    </c:if>
                                     <c:if test="${cat == null}">
                                    <div class="easion-card-title"> Add Form </div>
                                    </c:if>
<!--                                     <div class="easion-card-title"> Ajouter </div> -->
                                </div>
                                <div class="card-body ">
                                    
                                     <c:if test="${cat != null}">
                                     
                            <form action="${pageContext.request.contextPath}/Admin?page=editcat"   method="post">
                        </c:if>
                        <c:if test="${cat == null}">
                            <form action="${pageContext.request.contextPath}/Admin?page=newcat"  method="post">
                        </c:if>
                           
                                        <div class="form-group">
                                         <c:if test="${cat != null}">
                                         <input type="hidden" name="idcat" value="${cat.id}" />
                                         </c:if>
                                        <div class="easion-card-icon">
                               
                                            <label for="exampleFormControlInput1">Category Name</label>
                                            <input type="text" class="form-control" id="exampleFormControlInput1" value="${cat.nom}" name="name" placeholder="category name">
                                        </div>
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                    </form>
                                </div>
                            </div>
                             
</div>