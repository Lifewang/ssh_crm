package cn.itcast.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	@SuppressWarnings("rawtypes")
	private Class pClass;
	//���췽��
	@SuppressWarnings("rawtypes")
	public BaseDaoImpl() {
		
		//1 ��ǰ������Class
		Class clazz = this.getClass();
		
		/*2 �õ�������ĸ���Ĳ���������BaseDaoImpl<Customer>
		 * Type getGenericSuperclass()
		*/
		Type type = clazz.getGenericSuperclass();
		
		// ת�����ӽӿ�ParameterizedType
		ParameterizedType ptype = (ParameterizedType)type;
		
		/*3 ��ȡʵ�����Ͳ���Customer
		 * Type[] getActualTypeArguments()
		 */
		Type[] types = ptype.getActualTypeArguments();
		//��Type���Class
		Class tclass = (Class)types[0];
		this.pClass = tclass;
	}
	
	//���
	public void add(T t) {
		
		this.getHibernateTemplate().save(t);
	}

	//�޸�
	public void update(T t) {
		
		this.getHibernateTemplate().update(t);
	}
	
	//ɾ��
	public void delete(T t) {
		
		this.getHibernateTemplate().delete(t);
	}

	//����id��ѯ
	@SuppressWarnings("all")
	public T findOne(int id) {
		
		return (T) this.getHibernateTemplate().get(pClass, id);
	}

	//��ѯ����
	@SuppressWarnings("all")
	public List<T> findAll() {
		
		//ʹ��Class�����getSimpleName�����õ�������
		return this.getHibernateTemplate().find("from "+pClass.getSimpleName());
	}

}
