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
   <title>修改联系人</title>
 </head>
 <body>
  <div class="container">
     <div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15">修改联系人</b></div>
            <div class="box_center">
              <form action="${pageContext.request.contextPath}/linkman_addLinkMan.action" class="jqtransform" method="post">
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
                 <tr>
	                  <td class="td_right">所属客户：</td>
	                  <td class=""> 
	                    <select name="customer.cid" required>
	                    	<option value="">--请选择--</option>
							<c:forEach var="customer" items="${listCustomer }">
								<option value="${customer.cid }"  <c:if test="${customer.cid == linkman.customer.cid}">selected</c:if>>${customer.custName }</option>
							</c:forEach>
						</select>
	                  </td>
                 </tr>
                 <tr>
	                  <td class="td_right">姓名：</td>
	                  <td>
	                  	<input type="text" name="lkmName" class="input-text lh30" size="40"  value="${linkman.lkmName}" required>
	                  </td>
                </tr>
                <tr>
	                  <td class="td_right">性别：</td>
	                  <td class=""> 
	                    <label><input name="lkmGender" type="radio" value="男" <c:if test="${linkman.lkmGender=='男' }">checked</c:if> required>男</label>
						<label><input name="lkmGender" type="radio" value="女" <c:if test="${linkman.lkmGender=='女' }">checked</c:if> required>女</label>
	                  </td>
                 </tr>
                 <tr>
	                  <td class="td_right">固定电话：</td>
	                  <td class=""> 
	                    <input type="text" name="lkmPhone" class="input-text lh30" size="40" value="${linkman.lkmPhone }" required>
	                  </td>
                 </tr>
                 <tr>
	                  <td class="td_right">移动电话：</td>
	                  <td class=""> 
	                    <input type="text" name="lkmMobile" class="input-text lh30" size="40" value="${linkman.lkmMobile }" required>
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
  