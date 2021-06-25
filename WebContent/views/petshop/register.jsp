
<% request.setAttribute("title", "Register"); %> 
	<%@ include file="../includes/header.jsp" %>


<h1><%=request.getAttribute("test") %></h1>
<div class="center_content">
       	<div class="left_content">
            <div class="title"><span class="title_icon"><img src="${pageContext.request.contextPath}/views/images/bullet1.gif" alt="" title="" /></span>Register</div>
        
        	<div class="feat_prod_box_details">
            <p class="details">
             Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.
            </p>
            
              	<div class="contact_form">
                <div class="form_subtitle">create new account</div>
                 <form name="register" method="post" action="${context}/login?page=register">          
                    <div class="form_row">
                    <label class="contact"><strong>Username:</strong></label>
                    <input type="text" class="contact_input" required="required" name="name"/>
                    </div>  
                    <div class="form_row">
         				<label class="contact"><strong>Password</strong></label>
                    <input  type="password" class="contact_input" required="required" name="password" />
                  </div>

              		<div class="form_row" >
              		</div>
              	
                    <div class="form_row">
                    <label class="contact"><strong>Email:</strong></label>
                    <input type="text" class="contact_input" required="required" name="email" />
                    </div>


                    <div class="form_row">
                    <label class="contact"><strong>Phone:</strong></label>
                    <input type="text" class="contact_input" required="required" name="phone" />
                    </div>
                    
                    <div class="form_row">
                    <label class="contact"><strong>Company:</strong></label>
                    <input type="text" class="contact_input" required="required" name="company"/>
                    </div>
                    
                    <div class="form_row">
                    <label class="contact"><strong>Adrres:</strong></label>
                    <input type="text" class="contact_input" required="required" name="adresse"/>
                    </div>                    

                    <div class="form_row">
                        <div class="terms">
                        <input type="checkbox" name="terms" />
                        I agree to the <a href="#">terms &amp; conditions</a>                        </div>
                    </div> 

                    
                    <div class="form_row">
                    <input type="submit" class="register" value="register" />
                    </div>   
                  </form>     
                </div>  
            
          </div>	
            
              

            

            
        <div class="clear"></div>
        </div><!--end of left content-->



 		<%@ include file="../includes/right.jsp" %>

       
       <div class="clear"></div>
       <!--end of center content-->
        


        <%@ include file="../includes/footer.jsp" %>
        
 
</body>


</html>