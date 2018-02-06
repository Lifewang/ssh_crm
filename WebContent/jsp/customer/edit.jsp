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
   <title>修改客户信息</title>
 </head>
 <body>
  <div class="container">
     <div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15">修改客户信息</b></div>
            <div class="box_center">
              <form action="${pageContext.request.contextPath}/customer_update.action" class="jqtransform" method="post" name="form1">
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
                 <tr>
	                  <td class="td_right">客户名称：</td>
	                  <td class=""> 
	                    <input type="text" name="custName" class="input-text lh30" size="40"  value="${customer.custName }"  required>
	                  </td>
                 </tr>
                 <tr>
	                  <td class="td_right">客户级别：</td>
	                  <td>
	                  	<select name="dictCustLevel.did"  required>
							<option value="">--请选择--</option>
							<c:forEach var="dict" items="${listDict }">
								<option value="${dict.did }" <c:if test="${dict.did == customer.dictCustLevel.did}">selected</c:if>>${dict.dname }</option>
							</c:forEach>
						</select>
	                  </td>
                </tr>
                <tr>
	                  <td class="td_right">信息来源：</td>
	                  <td class=""> 
	                    <input type="text" name="custSource" class="input-text lh30" size="40" value="${customer.custSource }"  required>
	                  </td>
                 </tr>
                 <tr>
	                  <td class="td_right">固定电话：</td>
	                  <td class=""> 
	                    <input type="text" name="custPhone" class="input-text lh30" size="40" value="${customer.custPhone }"  required>
	                  </td>
                 </tr>
                 <tr>
	                  <td class="td_right">移动电话：</td>
	                  <td class=""> 
	                    <input type="text" name="custMobile" class="input-text lh30" size="40" value="${customer.custMobile }"  required>
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
  