package com.once.service;

import java.sql.SQLException;
import java.util.List;

import com.once.DAO.UserDao;
import com.once.exception.UserException;
import com.once.model.Teacher;
import com.once.model.User;

public class UserService {
	
	//����Dao
	UserDao userDao = new UserDao();
	
	public void register(User user)throws UserException{
		try {
			userDao.addUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("�û�ע��ʧ��!");
		}
	}
	
	public void registerTeacher(Teacher teacher)throws UserException{
		try {
			userDao.addTeacher(teacher);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("�û�ע��ʧ��!");
		}
	}
	
	public User Login(String stu_id,String stu_password)throws UserException{
		//��ѯ
		try {
			User user = userDao.findUserByStu_idAndstu_password(stu_id, stu_password);
			
			//�ж�
			if(user == null){
				throw new UserException("�û��������벻��ȷ");
			}
			
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("��½ʧ��");
		}
		
	}
	
	public void updatePassword(User user)throws UserException{
		
		try {
			userDao.updatePassword(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			throw new UserException("����");
		}
		
	}
	
	public List<User> UserInfo(String stu_tid) throws UserException{
		try {
			List<User> user = userDao.findUserByTeacher(stu_tid);
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("��ѯʧ��");
		}
	}
	
	public List<Teacher> TeacherInfo() throws UserException{
		try {
			List<Teacher> teacher = userDao.findTeacher();
			return teacher;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("��ѯʧ��");
		}
	}
}
