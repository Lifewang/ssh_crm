package cn.itcast.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.entity.Visit;

public class VisitDaoImpl extends HibernateDaoSupport implements VisitDao {

	
	public void addVisit(Visit visit) {
		
		this.getHibernateTemplate().save(visit);
	}

	@SuppressWarnings("all")
	public List<Visit> findAll() {
		
		return (List<Visit>)this.getHibernateTemplate().find("from Visit");
	}

}
