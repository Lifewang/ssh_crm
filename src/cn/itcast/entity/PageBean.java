package cn.itcast.entity;

import java.util.List;

public class PageBean {

	private Integer currentPage; //��ǰҳ
	private Integer totalCount; //�ܼ�¼��
	private Integer	pageSize;  //ÿҳ��ʾ��¼��
	private Integer totalPage; //��ҳ��
	private Integer begin;    //��ʼλ��
	private List<Customer> list; //ÿҳ��¼��list����
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public List<Customer> getList() {
		return list;
	}
	public void setList(List<Customer> list) {
		this.list = list;
	}
	
	
	
}
