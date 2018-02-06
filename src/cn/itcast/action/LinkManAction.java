package cn.itcast.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.itcast.entity.Customer;
import cn.itcast.entity.LinkMan;
import cn.itcast.service.CustomerService;
import cn.itcast.service.LinkManService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{

	private LinkManService linkManService;

	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	private LinkMan linkMan = new LinkMan();
	public LinkMan getModel() {
		
		return linkMan;
	}
	
	public String addLinkMan(){
		/*
		 *客户id不能直接封装 
		 */
		//原始方式实现
		/*String scid = ServletActionContext.getRequest().getParameter("cid");
		int cid = Integer.parseInt(scid);
		Customer c = new Customer();
		c.setCid(cid);
		linkMan.setCustomer(c);*/
		/*
		 * 简化写法：在表单中的name写成customer.cid
		 */
		linkManService.addLinkMan(linkMan);
		return "addLinkMan";
	}
	
	public String toAddPage(){
		
		//查询所有客户，将所有客户list集合传递到页面中显示（放到域对象）
		List<Customer> listCustomer = customerService.findAll();
		//放到域对象
		ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		return "toAddPage";
	}
	
	public String list(){
		
		List<LinkMan> list = linkManService.finAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}
	
	public String showLinkMan(){
		
		int linkid = linkMan.getLinkid();
		//根据id查询联系人信息
		LinkMan link = linkManService.findOne(linkid);
		
		//需要所有客户list集合
		List<Customer> listCustomer = customerService.findAll();
		
		//放到域对象
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("linkman", link);
		request.setAttribute("listCustomer", listCustomer);
		return "showLinkMan";
	}
	
	public String update(){
		
		linkManService.update(linkMan);
		return "update";
	}
	
	//联系人查询
	public String toSelectPage(){
		
		//查询所有客户
		List<Customer> list = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toSelectPage";
	}
	//查询操作
	public String moreCondition(){
		
		List<LinkMan> list = linkManService.findCondition(linkMan);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "moreCondition";
	}
	

}
