package cn.itcast.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	
	@SuppressWarnings("all")
	public User loginUser(User user) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("username", user.getUsername()));
		criteria.add(Restrictions.eq("password", user.getPassword()));
		User u = null;
		if(criteria != null){
			try {
				u = (User) this.getHibernateTemplate().findByCriteria(criteria).get(0);
			} catch (Exception e) {
				
			}
			return u;
		}
		return null;
	}

	//��ѯ�����û���Ӧ���ڿͻ��ݷü�¼
	@SuppressWarnings("all")
	public List<User> findAll() {
		
		return (List<User>)this.getHibernateTemplate().find("from User");
	}

	//��ѯ���ݿ��Ƿ��и��û�
	public User findByUsername(String username) {
		List<User> list = this.getHibernateTemplate().find("from User where username = ?",username);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	//�������ݵ����ݿ�
	public void save(User user) {
		
		this.getHibernateTemplate().save(user);
		
	}
	
	
}
