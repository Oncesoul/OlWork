package com.once.service;

import java.sql.SQLException;

import com.once.DAO.AdminAndTeacherDao;
import com.once.exception.UserException;
import com.once.model.Teacher;
import com.once.model.Admin;

public class AdminAndTeacherService {
	//创建DAO
	AdminAndTeacherDao adminAndTeacherDao = new AdminAndTeacherDao();
	
	//教师登录
	public Teacher Login(String teacher_id,String teacher_pwd)throws UserException{
		//查询
		try {
			Teacher teacher = adminAndTeacherDao.findTeacherByTeacher_idAndTeacher_pwd(teacher_id, teacher_pwd);
			
			//判断
			if(teacher == null){
				throw new UserException("用户名或密码不正确");
			}
			
			return teacher;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("登陆失败");
		}
		
	}
	
	//管理员
	public Admin AdminLogin(String admin_id,String admin_pwd)throws UserException{
		//查询
		try {
			Admin Admin = adminAndTeacherDao.FindAdminByIdAndPwd(admin_id, admin_pwd);
			
			//判断
			if(Admin == null){
				throw new UserException("用户名或密码不正确");
			}
			
			return Admin;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("登陆失败");
		}
		
	}
}
