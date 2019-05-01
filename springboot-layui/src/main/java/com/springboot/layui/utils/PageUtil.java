package com.springboot.layui.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageUtil<T> implements Serializable{
 
    private static final long serialVersionUID = 1L;
	private int code=0;
    private String msg;
    private Long count; //总条数
    private List<T> data = new ArrayList<T>(); //装前台当前页的数据
    public PageUtil() {
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public PageUtil(int code, String msg, Long count, List<T> data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}
	@Override
	public String toString() {
		return "PageUtil [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + "]";
	}
 
}
