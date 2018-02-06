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
   <title>客户级别统计</title>
 </head>
 <body>
  <div class="container">
      <div id="table" class="mt10">
        <div class="box span10 oh">
              <table  class="list_table">
                <tr>
                   <th width="50%">客户级别</th>
                   <th width="50%">数量</th>
                </tr>
                <c:forEach var="map" items="${list}">
	                <tr class="tr">
	                   <td class="line_table" align="center" width="50%">${map.dname}</td>
					   <td class="line_table" align="center" width="50%">${map.num}</td>
	                 </tr>
	             </c:forEach>
              </table>
        </div>
     </div>
   </div> 
 </body>
 </html>
  