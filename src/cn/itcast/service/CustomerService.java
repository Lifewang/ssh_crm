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
	
	//��װ��ҳ���ݵ�pageBean��������
	public PageBean listpage(Integer currentPage) {
		
		PageBean pageBean = new PageBean();
		//��ǰҳ
		pageBean.setCurrentPage(currentPage);
		
		//�ܼ�¼��
		int totalCount = customerDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		//ÿҳ��ʾ��¼��
		int pageSize = 3;
		
		//��ҳ��
		int totalPage = 0;
		if(totalCount%pageSize==0){
			totalPage = totalCount/pageSize;
		}else{
			totalPage= totalCount/pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//��ʼλ��
		int begin = (currentPage-1)*pageSize;
		
		//ÿҳ��¼��list����
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
