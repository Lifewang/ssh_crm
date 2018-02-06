<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <link rel="stylesheet" href="css/common.css">
  <link rel="stylesheet" href="css/style.css">
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
  <script type="text/javascript">
  $(function(){
      $(".sideMenu").slide({
         titCell:"h3", 
         targetCell:"ul",
         defaultIndex:0, 
         effect:'slideDown', 
         delayTime:'500' , 
         trigger:'click', 
         triggerTime:'150', 
         defaultPlay:true, 
         returnDefault:false,
         easing:'easeInQuint',
         endFun:function(){
              scrollWW();
         }
       });
      $(window).resize(function() {
          scrollWW();
      });
  });
  function scrollWW(){
    if($(".side").height()<$(".sideMenu").height()){
       $(".scroll").show();
       var pos = $(".sideMenu ul:visible").position().top-38;
       $('.sideMenu').animate({top:-pos});
    }else{
       $(".scroll").hide();
       $('.sideMenu').animate({top:0});
       n=1;
    }
  } 

var n=1;
function menuScroll(num){
  var Scroll = $('.sideMenu');
  var ScrollP = $('.sideMenu').position();
  /*alert(n);
  alert(ScrollP.top);*/
  if(num==1){
     Scroll.animate({top:ScrollP.top-38});
     n = n+1;
  }else{
    if (ScrollP.top > -38 && ScrollP.top != 0) { ScrollP.top = -38; }
    if (ScrollP.top<0) {
      Scroll.animate({top:38+ScrollP.top});
    }else{
      n=1;
    }
    if(n>1){
      n = n-1;
    }
  }
}
  </script>
  <title>客户关系管理系统</title>
</head>
<body>
    <div class="top">
      <div id="top_t">
        <div id="logo" class="fl"></div>
        <div id="photo_info" class="fr">
          <div id="photo" class="fl">
            <a href="#"><img src="images/a.png" alt="" width="60" height="60"></a>
          </div>
          <div id="base_info" class="fr">
            <div class="help_info">
              <a href="#" id="hp">&nbsp;</a>
              <a href="#" id="gy">&nbsp;</a>
              <a href="login.jsp" id="out">&nbsp;</a>
            </div>
            <div class="info_center">
              ${user.username}
              <span id="nt">通知</span><span><a href="#" id="notice">go</a></span>
            </div>
          </div>
        </div>
      </div>
      <div id="side_here">
        <div id="side_here_l" class="fl"></div>
        <div id="here_area" class="fl">当前位置：</div>
      </div>
    </div>
    <div class="side">
        <div class="sideMenu" style="margin:0 auto">
          <h3>客户管理</h3>
          <ul>
            <li><a href="${pageContext.request.contextPath}/customer_toAddPage.action" target="right">新增客户</a></li>
				<li><a href="${pageContext.request.contextPath}/customer_list.action" target="right">客户列表</a></li>
				<li><a href="${pageContext.request.contextPath}/customer_listpage.action?currentPage=1" target="right">分页客户列表</a></li>
          </ul>
          <h3>联系人管理</h3>
          <ul>
            <li><a href="${pageContext.request.contextPath }/linkman_toAddPage.action" target="right">新增联系人</a></li>
				<li><a href="${pageContext.request.contextPath }/linkman_list.action" target="right">联系人列表</a></li>
          </ul>
          <h3>客户拜访管理</h3>
          <ul>
            <li><a href="${pageContext.request.contextPath }/visit_toAddPage.action" target="right">新增客户拜访</a></li>
				<li><a href="${pageContext.request.contextPath }/visit_list.action" target="right">客户拜访列表</a></li>
          </ul>
          <h3>综合查询</h3>
          <ul>
            <li><a href="${pageContext.request.contextPath }/customer_toSelectCustomerPage.action" target="right">客户信息查询</a></li>
				<li><a href="${pageContext.request.contextPath }/linkman_toSelectPage.action" target="right">联系人信息查询</a></li>
          </ul>
          <h3>统计分析</h3>
          <ul>
            <li><a href="${pageContext.request.contextPath}/customer_countSource.action" target="right">客户来源统计</a></li>
				<li><a href="${pageContext.request.contextPath }/customer_countLevel.action" target="right">客户级别查询</a></li>
          </ul>
          <h3>系统设置</h3>
          <ul>
            <li><a href="login.jsp" target="login">注销退出</a></li>
          </ul>
       </div>
    </div>
    <div class="main">
       <iframe name="right" id="rightMain" src="right.html" frameborder="no" scrolling="auto" width="100%" height="auto" allowtransparency="true"></iframe>
    </div>
    <div class="bottom">
      <div id="bottom_bg">版权</div>
    </div>
    <div class="scroll">
          <a href="javascript:;" class="per" title="使用鼠标滚轴滚动侧栏" onclick="menuScroll(1);"></a>
          <a href="javascript:;" class="next" title="使用鼠标滚轴滚动侧栏" onclick="menuScroll(2);"></a>
    </div>
</body>

</html>