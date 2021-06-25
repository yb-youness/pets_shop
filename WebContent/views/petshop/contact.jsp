<% request.setAttribute("title", "Contact"); %> 
		<%@ include file="../includes/header.jsp" %>

 <div class="center_content">
       	<div class="left_content">
            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>Contact Us</div>
        
        	<div class="feat_prod_box_details">
            <p class="details">
             Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.
            </p>
              <form action="${context}/shop?page=sendmail" method="post">
              	<div class="contact_form">
                <div class="form_subtitle">all fields are requierd</div>          
                    <div class="form_row">
                    <label class="contact"><strong>Name:</strong></label>
                    <input type="text" name="name" class="contact_input" />
                    </div>  

                    <div class="form_row">
                    <label class="contact"><strong>Email:</strong></label>
                    <input type="text" name="email" class="contact_input" />
                    </div>


                    <div class="form_row">
                    <label class="contact"><strong>Phone:</strong></label>
                    <input type="text" name="phone" class="contact_input" />
                    </div>
                    
                    <div class="form_row">
                    <label class="contact"><strong>Company:</strong></label>
                    <input type="text" name="company" class="contact_input" />
                    </div>


                    <div class="form_row">
                    <label class="contact"><strong>Message:</strong></label>
                    <textarea class="contact_textarea" name="message" ></textarea>
                    </div>

                    
                    <div class="form_row">
                    <input type="submit" class="contact" value="send"></input>                    </div>
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