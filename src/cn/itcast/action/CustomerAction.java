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

@SuppressWarnings("serial")//用于抑制编译器产生警告信息
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	private Customer customer = new Customer();
	public Customer getModel() {
		
		return customer;
	}
	
	//添加
	public String toAddPage(){
		//查询所有级别
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
	
	//定义list变量
	/*private List<Customer> list;
	public List<Customer> getList() {
		return list;
	}*/

	//客户列表
	public String list(){
		
		List<Customer> list = customerService.findAll();
		//放到域对象
		ServletActionContext.getRequest().setAttribute("list", list);
		
		//返回的list放到值栈里面
		//list = customerService.findAll();
		return "list";
	}
	
	//删除
	public String delete(){
		//使用模型驱动获取表单提交cid值
		int cid = customer.getCid();
		//根据id查询
		Customer c = customerService.finOne(cid);
		//判断查询对象是否为空
		if(c != null){
			//调用方法删除
			customerService.delete(c);
		}
		return "delete";
	}

	//修改，根据id查询
	public String showCustomer(){
		//使用模型驱动获取表单提交cid值
		int cid = customer.getCid();
		//根据id查询
		Customer c = customerService.finOne(cid);
		
		//查询所有级别
		List<Dict> listDict = customerService.findAllDictLevel();
		//放到域对象里面
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("customer", c);
		request.setAttribute("listDict", listDict);
		return "showCustomer";
	}
	//修改方法
	public String update(){
		
		customerService.update(customer);
		return "update";
	}
	
	
	//属性封装
	private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	//分页方法
	public String listpage(){
		//调用service方法实现封装
		PageBean pageBean = customerService.listpage(currentPage);
		//放到域对象中
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "listpage";
	}
	
	//条件查询
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
	
	//查询客户信息
	public String toSelectCustomerPage(){
		
		return "toSelectCustomerPage";
	}
	//多条件查询
	public String moreCondition(){
		
		List<Customer> list = customerService.findMoreCondition(customer);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "moreCondition";
	}
	
	//根据来源统计
	@SuppressWarnings("all")
	public String countSource(){
		
		List list = customerService.findcountSource();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "countSource";
	}
	
	//根据级别统计
	public String countLevel(){
		
		List list = customerService.findCountLevel();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "countLevel";
	}
	
	
}
