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
   <title>客户拜访列表</title>
 </head>
 <body>
  <div class="container">
      <div id="table" class="mt10">
        <div class="box span10 oh">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr>
                   <th width="100">用户名称</th>
                   <th width="100">客户名称</th>
                   <th width="100">拜访地址</th>
                   <th width="100">拜访内容</th>
                </tr>
                <c:forEach var="visit" items="${list}">
	                <tr class="tr">
	                    <td align="center">${visit.user.username}</td>
		                <td align="center">${visit.customer.custName}</td>
		                <td align="center">${visit.vaddress}</td>
		                <td align="center">${visit.vcontent}</td>
	                 </tr>
	             </c:forEach>
              </table>
        </div>
     </div>
   </div> 
 </body>
 </html>
  