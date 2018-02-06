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
	
	//��ת��ע��ҳ��
	public String registPage(){
		
		return "registPage";
	}
	/*
	 * ajax�첽У���û���
	 */
	public String findByName() throws IOException{
		
		//����service����
		User existUser = userService.findByUsername(user.getUsername());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		if(existUser != null){
			response.getWriter().println("<font color='red'>�û����Ѿ�����</font>");
		}else{
			response.getWriter().println("<font color='green'>�û�������ʹ��</font>");
		}
		return NONE;
	}
	
	//ע�����
	public String register(){
		
		userService.save(user);
		return "register";
	}
}
