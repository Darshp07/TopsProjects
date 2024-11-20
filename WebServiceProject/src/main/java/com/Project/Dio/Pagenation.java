package com.Project.Dio;

import java.util.List;

public class Pagenation<T> {

	private int currentPage;
	private int totalPages;
	private long totalElements;
	private int pageSize;
	private List<T> content;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getContent() {
		return content;
	}
	public void setContent(List<T> content) {
		this.content = content;
	}
	public Pagenation(int currentPage, int totalPages, long l, int pageSize, List<T> content) {
		
		this.currentPage = currentPage;
		this.totalPages = totalPages;
		this.totalElements = l;
		this.pageSize = pageSize;
		this.content = content;
	}
	
	
}
