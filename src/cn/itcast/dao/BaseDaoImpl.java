package cn.itcast.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	@SuppressWarnings("rawtypes")
	private Class pClass;
	//构造方法
	@SuppressWarnings("rawtypes")
	public BaseDaoImpl() {
		
		//1 当前运行类Class
		Class clazz = this.getClass();
		
		/*2 得到运行类的父类的参数化类型BaseDaoImpl<Customer>
		 * Type getGenericSuperclass()
		*/
		Type type = clazz.getGenericSuperclass();
		
		// 转换成子接口ParameterizedType
		ParameterizedType ptype = (ParameterizedType)type;
		
		/*3 获取实际类型参数Customer
		 * Type[] getActualTypeArguments()
		 */
		Type[] types = ptype.getActualTypeArguments();
		//把Type变成Class
		Class tclass = (Class)types[0];
		this.pClass = tclass;
	}
	
	//添加
	public void add(T t) {
		
		this.getHibernateTemplate().save(t);
	}

	//修改
	public void update(T t) {
		
		this.getHibernateTemplate().update(t);
	}
	
	//删除
	public void delete(T t) {
		
		this.getHibernateTemplate().delete(t);
	}

	//根据id查询
	@SuppressWarnings("all")
	public T findOne(int id) {
		
		return (T) this.getHibernateTemplate().get(pClass, id);
	}

	//查询所有
	@SuppressWarnings("all")
	public List<T> findAll() {
		
		//使用Class里面的getSimpleName（）得到类名称
		return this.getHibernateTemplate().find("from "+pClass.getSimpleName());
	}

}
