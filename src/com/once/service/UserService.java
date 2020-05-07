package com.once.service;

import java.sql.SQLException;
import java.util.List;

import com.once.DAO.UserDao;
import com.once.exception.UserException;
import com.once.model.Teacher;
import com.once.model.User;

public class UserService {
	
	//创建Dao
	UserDao userDao = new UserDao();
	
	public void register(User user)throws UserException{
		try {
			userDao.addUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("用户注册失败!");
		}
	}
	
	public void registerTeacher(Teacher teacher)throws UserException{
		try {
			userDao.addTeacher(teacher);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("用户注册失败!");
		}
	}
	
	public User Login(String stu_id,String stu_password)throws UserException{
		//查询
		try {
			User user = userDao.findUserByStu_idAndstu_password(stu_id, stu_password);
			
			//判断
			if(user == null){
				throw new UserException("用户名或密码不正确");
			}
			
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("登陆失败");
		}
		
	}
	
	public void updatePassword(User user)throws UserException{
		
		try {
			userDao.updatePassword(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			throw new UserException("错误");
		}
		
	}
	
	public List<User> UserInfo(String stu_tid) throws UserException{
		try {
			List<User> user = userDao.findUserByTeacher(stu_tid);
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("查询失败");
		}
	}
	
	public List<Teacher> TeacherInfo() throws UserException{
		try {
			List<Teacher> teacher = userDao.findTeacher();
			return teacher;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("查询失败");
		}
	}
}
