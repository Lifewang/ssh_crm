package cn.itcast.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.entity.LinkMan;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

	//�����ϵ��
	public void add(LinkMan linkMan) {
		
		this.getHibernateTemplate().save(linkMan);
	}

	//������ϵ����Ϣ
	@SuppressWarnings("all")
	public List<LinkMan> findAll() {
		
		return (List<LinkMan>)this.getHibernateTemplate().find("from LinkMan");
	}

	//����id��ѯ��ϵ��
	public LinkMan findOne(int linkid) {
		
		return (LinkMan) this.getHibernateTemplate().get(LinkMan.class, linkid);
	}

	//�޸���ϵ��
	public void update(LinkMan linkMan) {
		
		this.getHibernateTemplate().update(linkMan);
	}

	//��������ѯ
	@SuppressWarnings("all")
	public List<LinkMan> findCondition(LinkMan linkMan) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
		if(linkMan.getLkmName()!=null && !"".equals(linkMan.getLkmName())){
			criteria.add(Restrictions.like("lkmName","%"+linkMan.getLkmName()+"%"));
		}
		if(linkMan.getCustomer().getCid()!=null && linkMan.getCustomer().getCid()>0){
			criteria.add(Restrictions.eq("customer.cid", linkMan.getCustomer().getCid()));
		}
		List<LinkMan> list = (List<LinkMan>)this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

}
