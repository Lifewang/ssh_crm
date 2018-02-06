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

	/*//��ӿͻ�����
	public void add(Customer customer) {
		
		this.getHibernateTemplate().save(customer);
	}

	//�ͻ��б���
	@SuppressWarnings("all")
	public List<Customer> findAll() {
		
		return (List<Customer>)this.getHibernateTemplate().find("from Customer");
	}

	//����id��ѯ
	public Customer findOne(int cid) {
		
		return (Customer) this.getHibernateTemplate().get(Customer.class,cid);
	}

	//ɾ��
	public void delete(Customer c) {
		
		this.getHibernateTemplate().delete(c);
	}

	//�޸�
	public void update(Customer customer) {
		
		this.getHibernateTemplate().update(customer);
	}*/

	//��ѯ��¼��
	@SuppressWarnings("all")
	public int findCount() {
		//����HibernateTemplate�����find����ʵ��
		List<Object> list = (List<Object>)this.getHibernateTemplate().find("select count(*) from Customer");
		if(list != null && list.size() != 0){
			//��list�а�ֵ�õ���ת����int����
			Object obj = list.get(0);
			Long lobj = (Long) obj;
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

	//��ҳ����
	@SuppressWarnings("all")
	public List<Customer> findPage(int begin, int pageSize) {
		
		//�������߶������ö��ĸ�ʵ�����ͽ��в���
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//����hibernateTemplate����ķ���ʵ��
		List<Customer> list = (List<Customer>)this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	//������ѯ
	@SuppressWarnings("all")
	public List<Customer> findlistCondition(Customer customer) {
		
		//��һ�ַ�ʽ������hibernateTemplate����ķ���ʵ��
		//List<Customer> list = (List<Customer>)this.getHibernateTemplate().find("from Customer where custName like ?", "%"+customer.getCustName()+"%");
		
		//�ڶ��ַ�ʽ��Ӧ�öࣩ���������߶������ö��ĸ�ʵ�����ͽ��в���
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//���ö�ʵ�����ĸ�����
		criteria.add(Restrictions.like("custName", "%"+customer.getCustName()+"%"));
		//����hibernateTemplate����ķ���ʵ��
		List<Customer> list = (List<Customer>)this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

	//��������ϲ�ѯ
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

	//��ѯ���м���
	@SuppressWarnings("all")
	public List<Dict> findAllDictLevel() {
		
		return ( List<Dict>)this.getHibernateTemplate().find("from Dict");
	}

	//�ͻ���Դͳ��
	@SuppressWarnings("all")
	public List findcountSource() {
		//�õ�session����
		Session session = this.getSessionFactory().getCurrentSession();
		//����sqlquery����
		SQLQuery sqlQuery = session.createSQLQuery("select count(*) as num,custSource from t_customer group by custSource");
		
		/*
		 * ��Ϊ����ֵ�������ֶΣ�һ���ֶ���id��һ��������
		 * ���԰ѷ�������ת����map�ṹ
		 */
		sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		//sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		
		//���÷����õ����
		//����list��Ĭ��ÿ������������ʽ
		List list = sqlQuery.list();
	
		return list;
	}

	//�ͻ�����ͳ��
	public List findCountLevel() {
		
		//�õ�session����
		Session session = this.getSessionFactory().getCurrentSession();
		//����sqlquery����
		SQLQuery sqlQuery = session.createSQLQuery("SELECT c.num,d.dname FROM(SELECT COUNT(*) AS num,custLevel FROM t_customer	GROUP BY custLevel)c,t_dict d WHERE c.custLevel = d.did");
		sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		//���÷����õ����
		//����list��Ĭ��ÿ������������ʽ
		List list = sqlQuery.list();
		
		return list;
	}


}
