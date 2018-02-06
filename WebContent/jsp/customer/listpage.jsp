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
   <title>客户列表</title>
 </head>
 <body>
  <div class="container">
      <div id="table" class="mt10">
        <div class="box span10 oh">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr>
                   <th width="100">客户名称</th>
                   <th width="100">客户级别</th>
                   <th width="100">信息来源</th>
                   <th width="100">固定电话</th>
                   <th width="100">移动电话</th>
                   <th width="100">操作</th>
                </tr>
                <c:forEach var="customer" items="${pageBean.list}">
	                <tr class="tr">
	                   <td align="center">${customer.custName}</td>
							<td align="center">${customer.dictCustLevel.dname}</td>
							<td align="center">${customer.custSource}</td>
							<td align="center">${customer.custPhone}</td>
							<td align="center">${customer.custMobile}</td>
							<td align="center">
								<a href="${pageContext.request.contextPath}/customer_showCustomer.action?cid=${customer.cid}">修改</a>&nbsp;
								<a href="${pageContext.request.contextPath}/customer_delete.action?cid=${customer.cid}">删除</a>
							</td>
	                 </tr>
	             </c:forEach>
              </table>
              <div class="page mt10">
                <div class="pagination">
                  <ul>
                  	  <li class="first-child"><a href="#"><span>第${pageBean.currentPage }页</span></a></li>
                  	  <c:if test="${pageBean.currentPage!=1 }">
                      		<li class="disabled"><span><a href="${pageContext.request.contextPath}/customer_listpage.action?currentPage=${pageBean.currentPage-1}">上一页</a></span></li>
                      </c:if>
                      <li class="active"><span>共${pageBean.totalCount }条记录</span></li>
                      <c:if test="${pageBean.currentPage!=pageBean.totalPage }">
                      		<li class="disabled"><span><a href="${pageContext.request.contextPath}/customer_listpage.action?currentPage=${pageBean.currentPage+1}">下一页</a></span></li>
                      </c:if>
                      <li class="last-child"><a href="#"><span>共${pageBean.totalPage }页</span></a></li>
                  </ul>
                </div>

              </div>
        </div>
     </div>
   </div> 
 </body>
 </html>
  