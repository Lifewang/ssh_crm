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
   <title>联系人列表</title>
 </head>
 <body>
  <div class="container">
      <div id="table" class="mt10">
        <div class="box span10 oh">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr>
                   <th width="100">所属客户</th>
                   <th width="100">姓名</th>
                   <th width="100">性别</th>
                   <th width="100">固定电话</th>
                   <th width="100">移动电话</th>
                   <th width="100">操作</th>
                </tr>
                <c:forEach var="linkman" items="${list}">
	                <tr class="tr">
		                <td align="center">${linkman.customer.custName}</td>
	                    <td align="center">${linkman.lkmName}</td>
		                <td align="center">${linkman.lkmGender}</td>
		                <td align="center">${linkman.lkmPhone}</td>
		                <td align="center">${linkman.lkmMobile}</td>
		                <td align="center">
		                    <a href="${pageContext.request.contextPath}/linkman_showLinkMan.action?linkid=${linkman.linkid}">修改</a>
		                </td>
	                 </tr>
	             </c:forEach>
              </table>
        </div>
     </div>
   </div> 
 </body>
 </html>
  