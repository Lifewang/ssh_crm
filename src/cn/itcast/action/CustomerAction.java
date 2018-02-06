package cn.itcast.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;
import cn.itcast.entity.PageBean;
import cn.itcast.service.CustomerService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")//�������Ʊ���������������Ϣ
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	private Customer customer = new Customer();
	public Customer getModel() {
		
		return customer;
	}
	
	//���
	public String toAddPage(){
		//��ѯ���м���
		List<Dict> listDict = customerService.findAllDictLevel();
		ServletActionContext.getRequest().setAttribute("listDict", listDict);
		return "toAddPage";
	}
	public String add(){
		
		try {
			customerService.add(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "add";
	}
	
	//����list����
	/*private List<Customer> list;
	public List<Customer> getList() {
		return list;
	}*/

	//�ͻ��б�
	public String list(){
		
		List<Customer> list = customerService.findAll();
		//�ŵ������
		ServletActionContext.getRequest().setAttribute("list", list);
		
		//���ص�list�ŵ�ֵջ����
		//list = customerService.findAll();
		return "list";
	}
	
	//ɾ��
	public String delete(){
		//ʹ��ģ��������ȡ���ύcidֵ
		int cid = customer.getCid();
		//����id��ѯ
		Customer c = customerService.finOne(cid);
		//�жϲ�ѯ�����Ƿ�Ϊ��
		if(c != null){
			//���÷���ɾ��
			customerService.delete(c);
		}
		return "delete";
	}

	//�޸ģ�����id��ѯ
	public String showCustomer(){
		//ʹ��ģ��������ȡ���ύcidֵ
		int cid = customer.getCid();
		//����id��ѯ
		Customer c = customerService.finOne(cid);
		
		//��ѯ���м���
		List<Dict> listDict = customerService.findAllDictLevel();
		//�ŵ����������
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("customer", c);
		request.setAttribute("listDict", listDict);
		return "showCustomer";
	}
	//�޸ķ���
	public String update(){
		
		customerService.update(customer);
		return "update";
	}
	
	
	//���Է�װ
	private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	//��ҳ����
	public String listpage(){
		//����service����ʵ�ַ�װ
		PageBean pageBean = customerService.listpage(currentPage);
		//�ŵ��������
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "listpage";
	}
	
	//������ѯ
	public String listcondition(){
		if(customer.getCustName() != null && !"".equals(customer.getCustName())){
			List<Customer> list = customerService.findlistCondition(customer);
			ServletActionContext.getRequest().setAttribute("list", list);
		}else{
			List<Customer> list = customerService.findAll();
			ServletActionContext.getRequest().setAttribute("list", list);
		}
		return "listcondition";
	}
	
	//��ѯ�ͻ���Ϣ
	public String toSelectCustomerPage(){
		
		return "toSelectCustomerPage";
	}
	//��������ѯ
	public String moreCondition(){
		
		List<Customer> list = customerService.findMoreCondition(customer);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "moreCondition";
	}
	
	//������Դͳ��
	@SuppressWarnings("all")
	public String countSource(){
		
		List list = customerService.findcountSource();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "countSource";
	}
	
	//���ݼ���ͳ��
	public String countLevel(){
		
		List list = customerService.findCountLevel();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "countLevel";
	}
	
	
}
