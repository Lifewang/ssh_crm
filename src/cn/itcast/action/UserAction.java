package cn.itcast.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.itcast.entity.User;
import cn.itcast.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private User user= new User();
	public User getModel() {
		
		return user;
	}
	
	public String login() {

		User u = userService.login(user);
		if(u != null){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("user", u);
			return "loginsuccess";
		}else{
			return "login";
		}
	}
	
	//跳转至注册页面
	public String registPage(){
		
		return "registPage";
	}
	/*
	 * ajax异步校验用户名
	 */
	public String findByName() throws IOException{
		
		//调用service方法
		User existUser = userService.findByUsername(user.getUsername());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		if(existUser != null){
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
		}else{
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		return NONE;
	}
	
	//注册操作
	public String register(){
		
		userService.save(user);
		return "register";
	}
}
