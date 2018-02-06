package cn.itcast.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.CustomerDao;
import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;
import cn.itcast.entity.PageBean;

@Transactional
public class CustomerService {

	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void add(Customer customer) throws Exception {
		customerDao.add(customer);
	}

	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	public Customer finOne(int cid) {
		// TODO Auto-generated method stub
		return customerDao.findOne(cid);
	}

	public void delete(Customer c) {
		
		customerDao.delete(c);
	}

	public void update(Customer customer) {
		
		customerDao.update(customer);
	}
	
	//封装分页数据到pageBean对象里面
	public PageBean listpage(Integer currentPage) {
		
		PageBean pageBean = new PageBean();
		//当前页
		pageBean.setCurrentPage(currentPage);
		
		//总记录数
		int totalCount = customerDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		//每页显示记录数
		int pageSize = 3;
		
		//总页数
		int totalPage = 0;
		if(totalCount%pageSize==0){
			totalPage = totalCount/pageSize;
		}else{
			totalPage= totalCount/pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//开始位置
		int begin = (currentPage-1)*pageSize;
		
		//每页记录的list集合
		List<Customer> list = customerDao.findPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	public List<Customer> findlistCondition(Customer customer) {
		
		return customerDao.findlistCondition(customer);
	}

	public List<Customer> findMoreCondition(Customer customer) {
		
		return customerDao.findMoreCondition(customer);
	}

	public List<Dict> findAllDictLevel() {
		
		return customerDao.findAllDictLevel();
	}

	public List findcountSource() {
		
		return customerDao.findcountSource();
	}

	public List findCountLevel() {
		
		return customerDao.findCountLevel();
	}

	
}
