<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
 <head>
   <meta charset="UTF-8">
   <link rel="stylesheet" href="css/common.css">
   <link rel="stylesheet" href="css/main.css">
   <script type="text/javascript" src="js/jquery.min.js"></script>
   <script type="text/javascript" src="js/colResizable-1.3.min.js"></script>
   <script type="text/javascript" src="js/common.js"></script>
   
   <script type="text/javascript">
      $(function(){  
        $(".list_table").colResizable({
          liveDrag:true,
          gripInnerHtml:"<div class='grip'></div>", 
          draggingClass:"dragging", 
          minWidth:30
        }); 
        
      }); 
   </script>
   <title>新增客户拜访</title>
 </head>
 <body>
  <div class="container">
     <div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15">新增客户拜访</b></div>
            <div class="box_center">
              <form action="${pageContext.request.contextPath}/customer_add.action" class="jqtransform" method="post" name="form1">
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
                 <tr>
	                  <td class="td_right">所属客户：</td>
	                  <td class=""> 
	                    <select name="customer.cid" required>
							<option value="">--请选择--</option>
							<c:forEach var="customer" items="${listCustomer }">
								<option value="${customer.cid }">${customer.custName }</option>
							</c:forEach>
						</select>
	                  </td>
                 </tr>
                 <tr>
	                  <td class="td_right">所属用户：</td>
	                  <td>
	                  	<select name="user.uid" required>
							<option value="">--请选择--</option>
							<c:forEach var="user" items="${listUser }">
								<option value="${user.uid }">${user.username }</option>
							</c:forEach>
						</select>
	                  </td>
                </tr>
                <tr>
	                  <td class="td_right">拜访地址：</td>
	                  <td class=""> 
	                    <input type="text" name="vaddress" class="input-text lh30" size="40" required>
	                  </td>
                 </tr>
                 <tr>
	                  <td class="td_right">拜访内容：</td>
	                  <td class=""> 
	                    <input type="text" name="vcontent" class="input-text lh30" size="40" required>
	                  </td>
                 </tr>
                 <tr>
                   <td class="td_right">&nbsp;</td>
                   <td class="">
                     <input type="submit" class="btn btn82 btn_save2" value="保存">
                   </td>
                 </tr>
               </table>
               </form>
            </div>
          </div>
        </div>
     </div>
   </div> 
 </body>
 </html>
  