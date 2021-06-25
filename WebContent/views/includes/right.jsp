 
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
         <div class="right_content">
        	<div class="languages_box">
            <span class="red"><fmt:message key="right.lang" /></span>
            <a href="${context}/shop?page=setlang&lang=en" class="selected"><img src="${pageContext.request.contextPath}/views/images/gb.gif" alt="" title="" border="0" /></a>
            <a href="${context}/shop?page=setlang&lang=fr"><img src="${pageContext.request.contextPath}/views/images/fr.gif" alt="" title="" border="0" /></a>
            <a href="${context}/shop?page=setlang&lang=de"><img src="${pageContext.request.contextPath}/views/images/de.gif" alt="" title="" border="0" /></a>
                
                
              <div class="cart">
                  
              
              </div>
                   </div>     
            	
        
        
             <div class="title"><span class="title_icon"><img src="${pageContext.request.contextPath}/views/images/bullet3.gif" alt="" title="" /></span>About Our Shop</div> 
             <div class="about">
             <p>
             <img src="images/about.gif" alt="" title="" class="right" />
             Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.
             </p>
             
             </div>
             
             <div class="right_box">
              
             	<div class="title"><span class="title_icon"><img src="${pageContext.request.contextPath}/views/images/bullet4.gif" alt="" title="" /></span>Produit</div> 
                   <c:forEach items="${listproducts}" var="prod">
                    <div class="new_prod_box">
                        <a href="details.html">${prod.nom}</a>
                        <div class="new_prod_bg">
                        <span class="new_icon"><img src="${pageContext.request.contextPath}/views/images/promo_icon.gif" alt="" title="" /></span>
                        <a href="details.html"><img src="data:image/png;base64,${prod.image}" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>
                              
              </c:forEach>  
             </div>
             
             <div class="right_box">
             
             	<div class="title"><span class="title_icon"><img src="${pageContext.request.contextPath}/views/images/bullet5.gif" alt="" title="" /></span>Categories</div> 
                 <ul class="list">
                  <c:forEach items="${listCategory}" var="categorie">
                  
                <li><a href="#"> <c:out value="${categorie.nom}" /> </a></li>
                
                  </c:forEach>                               
                </ul>
                                                                                                                                                            
	
               
<%--              	<div class="title"><span class="title_icon"><img src="${pageContext.request.contextPath}/views/images/bullet6.gif" alt="" title="" /></span>Partners</div>  --%>
                
<!--                 <ul class="list"> -->
<!--                 <li><a href="#">accesories</a></li> -->
<!--                 <li><a href="#">pets gifts</a></li> -->
<!--                 <li><a href="#">specials</a></li> -->
<!--                 <li><a href="#">hollidays gifts</a></li> -->
<!--                 <li><a href="#">accesories</a></li> -->
<!--                 <li><a href="#">pets gifts</a></li> -->
<!--                 <li><a href="#">specials</a></li> -->
<!--                 <li><a href="#">hollidays gifts</a></li> -->
<!--                 <li><a href="#">accesories</a></li>                               -->
<!--                 </ul>       -->
             
             </div>         
             
        
        </div><!--end of right content-->