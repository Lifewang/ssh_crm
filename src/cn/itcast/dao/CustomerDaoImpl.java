package cn.itcast.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	/*//添加客户功能
	public void add(Customer customer) {
		
		this.getHibernateTemplate().save(customer);
	}

	//客户列表功能
	@SuppressWarnings("all")
	public List<Customer> findAll() {
		
		return (List<Customer>)this.getHibernateTemplate().find("from Customer");
	}

	//根据id查询
	public Customer findOne(int cid) {
		
		return (Customer) this.getHibernateTemplate().get(Customer.class,cid);
	}

	//删除
	public void delete(Customer c) {
		
		this.getHibernateTemplate().delete(c);
	}

	//修改
	public void update(Customer customer) {
		
		this.getHibernateTemplate().update(customer);
	}*/

	//查询记录数
	@SuppressWarnings("all")
	public int findCount() {
		//调用HibernateTemplate里面的find方法实现
		List<Object> list = (List<Object>)this.getHibernateTemplate().find("select count(*) from Customer");
		if(list != null && list.size() != 0){
			//从list中把值得到，转换成int类型
			Object obj = list.get(0);
			Long lobj = (Long) obj;
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

	//分页操作
	@SuppressWarnings("all")
	public List<Customer> findPage(int begin, int pageSize) {
		
		//创建离线对象，设置对哪个实体类型进行操作
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//调用hibernateTemplate里面的方法实现
		List<Customer> list = (List<Customer>)this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	//条件查询
	@SuppressWarnings("all")
	public List<Customer> findlistCondition(Customer customer) {
		
		//第一种方式：调用hibernateTemplate里面的方法实现
		//List<Customer> list = (List<Customer>)this.getHibernateTemplate().find("from Customer where custName like ?", "%"+customer.getCustName()+"%");
		
		//第二种方式（应用多）：创建离线对象，设置对哪个实体类型进行操作
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//设置对实体类哪个属性
		criteria.add(Restrictions.like("custName", "%"+customer.getCustName()+"%"));
		//调用hibernateTemplate里面的方法实现
		List<Customer> list = (List<Customer>)this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

	//多条件组合查询
	@SuppressWarnings("all")
	public List<Customer> findMoreCondition(Customer customer) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		if(customer.getCustName()!=null && !"".equals(customer.getCustName())){
			criteria.add(Restrictions.like("custName", "%"+customer.getCustName()+"%"));
		}
		/*if(customer.getCustLevel()!=null && !"".equals(customer.getCustLevel())){
			criteria.add(Restrictions.like("custLevel", "%"+customer.getCustLevel()+"%"));
		}*/
		if(customer.getCustSource()!=null && !"".equals(customer.getCustSource())){
			criteria.add(Restrictions.like("custSource", "%"+customer.getCustSource()+"%"));
		}
		List<Customer> list = (List<Customer>)this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

	//查询所有级别
	@SuppressWarnings("all")
	public List<Dict> findAllDictLevel() {
		
		return ( List<Dict>)this.getHibernateTemplate().find("from Dict");
	}

	//客户来源统计
	@SuppressWarnings("all")
	public List findcountSource() {
		//得到session对象
		Session session = this.getSessionFactory().getCurrentSession();
		//创建sqlquery对象
		SQLQuery sqlQuery = session.createSQLQuery("select count(*) as num,custSource from t_customer group by custSource");
		
		/*
		 * 因为返回值有两个字段，一个字段是id，一个是名称
		 * 所以把返回数据转换成map结构
		 */
		sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		//sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		
		//调用方法得到结果
		//返回list，默认每部分是数组形式
		List list = sqlQuery.list();
	
		return list;
	}

	//客户级别统计
	public List findCountLevel() {
		
		//得到session对象
		Session session = this.getSessionFactory().getCurrentSession();
		//创建sqlquery对象
		SQLQuery sqlQuery = session.createSQLQuery("SELECT c.num,d.dname FROM(SELECT COUNT(*) AS num,custLevel FROM t_customer	GROUP BY custLevel)c,t_dict d WHERE c.custLevel = d.did");
		sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		//调用方法得到结果
		//返回list，默认每部分是数组形式
		List list = sqlQuery.list();
		
		return list;
	}


}
