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
		 *�ͻ�id����ֱ�ӷ�װ 
		 */
		//ԭʼ��ʽʵ��
		/*String scid = ServletActionContext.getRequest().getParameter("cid");
		int cid = Integer.parseInt(scid);
		Customer c = new Customer();
		c.setCid(cid);
		linkMan.setCustomer(c);*/
		/*
		 * ��д�����ڱ��е�nameд��customer.cid
		 */
		linkManService.addLinkMan(linkMan);
		return "addLinkMan";
	}
	
	public String toAddPage(){
		
		//��ѯ���пͻ��������пͻ�list���ϴ��ݵ�ҳ������ʾ���ŵ������
		List<Customer> listCustomer = customerService.findAll();
		//�ŵ������
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
		//����id��ѯ��ϵ����Ϣ
		LinkMan link = linkManService.findOne(linkid);
		
		//��Ҫ���пͻ�list����
		List<Customer> listCustomer = customerService.findAll();
		
		//�ŵ������
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("linkman", link);
		request.setAttribute("listCustomer", listCustomer);
		return "showLinkMan";
	}
	
	public String update(){
		
		linkManService.update(linkMan);
		return "update";
	}
	
	//��ϵ�˲�ѯ
	public String toSelectPage(){
		
		//��ѯ���пͻ�
		List<Customer> list = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toSelectPage";
	}
	//��ѯ����
	public String moreCondition(){
		
		List<LinkMan> list = linkManService.findCondition(linkMan);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "moreCondition";
	}
	

}
