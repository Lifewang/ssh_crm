package cn.itcast.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.itcast.entity.Customer;
import cn.itcast.entity.User;
import cn.itcast.entity.Visit;
import cn.itcast.service.CustomerService;
import cn.itcast.service.UserService;
import cn.itcast.service.VisitService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class VisitAction extends ActionSupport implements ModelDriven<Visit>{

	private VisitService visitService;
	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}
	private CustomerService customerService;	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private Visit visit = new Visit();
	public Visit getModel() {
		
		return visit;
	}

	public String toAddPage(){
		//��ѯ���пͻ�
		List<Customer> listCustomer = customerService.findAll();
		
		//��ѯ�����û�
		List<User> listUser = userService.findAll();
		
		//�ŵ������
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listCustomer", listCustomer);
		request.setAttribute("listUser", listUser);
		return "toAddPage";
	}
	
	public String addVisit(){
		
		visitService.addVisit(visit);
		return "addVisit";
	}
	
	public String list(){
		
		List<Visit> list = visitService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}
	
	
}
