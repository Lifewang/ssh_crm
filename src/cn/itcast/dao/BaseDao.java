package cn.itcast.dao;

import java.util.List;

/**
 * ����������T��������������
 * @author Mr
 *
 * @param <T>
 */
public interface BaseDao<T> {

	//����
	void add(T t);
	
	//�޸�
	void update(T t);
	
	//ɾ��
	void delete(T t);
	
	//����id��ѯ
	T findOne(int id);
	
	//��ѯ����
	List<T> findAll();
}