package com.once.model;

public class User {
	private int stu_id;//学生id
	private String stu_name;//学生姓名
	private String stu_tid;//教师id
	private String stu_password;//学生密码
	private String newPassword;
	private String old_password;
	
	public String getOld_password() {
		return old_password;
	}
	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getStu_password() {
		return stu_password;
	}
	public void setStu_password(String stu_password) {
		this.stu_password = stu_password;
	}
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_tid() {
		return stu_tid;
	}
	public void setStu_tid(String stu_tid) {
		this.stu_tid = stu_tid;
	}
	@Override
	public String toString() {
		return "User [stu_id=" + stu_id + ", stu_name=" + stu_name + ", stu_tid=" + stu_tid + ", stu_password="
				+ stu_password + ", newPassword=" + newPassword + ", old_password="
				+ old_password + "]";
	}

}
