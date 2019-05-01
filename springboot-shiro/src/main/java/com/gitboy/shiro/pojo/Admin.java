package com.gitboy.shiro.pojo;

import java.io.Serializable;

public class Admin implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int admin_id;
	private String admin_username;
	private int    admin_role;
	private String  idCard_id;
	private String  info;
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_username() {
		return admin_username;
	}
	public void setAdmin_username(String admin_username) {
		this.admin_username = admin_username;
	}
	public int getAdmin_role() {
		return admin_role;
	}
	public void setAdmin_role(int admin_role) {
		this.admin_role = admin_role;
	}
	public String getIdCard_id() {
		return idCard_id;
	}
	public void setIdCard_id(String idCard_id) {
		this.idCard_id = idCard_id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_username=" + admin_username + ", admin_role=" + admin_role
				+ ", idCard_id=" + idCard_id + ", info=" + info + "]";
	}
	public Admin(int admin_id, String admin_username, int admin_role, String idCard_id, String info) {
		super();
		this.admin_id = admin_id;
		this.admin_username = admin_username;
		this.admin_role = admin_role;
		this.idCard_id = idCard_id;
		this.info = info;
	}
	

}
