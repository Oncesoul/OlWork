package com.once.service;

import java.sql.SQLException;

import com.once.DAO.AdminAndTeacherDao;
import com.once.exception.UserException;
import com.once.model.Teacher;
import com.once.model.Admin;

public class AdminAndTeacherService {
	//����DAO
	AdminAndTeacherDao adminAndTeacherDao = new AdminAndTeacherDao();
	
	//��ʦ��¼
	public Teacher Login(String teacher_id,String teacher_pwd)throws UserException{
		//��ѯ
		try {
			Teacher teacher = adminAndTeacherDao.findTeacherByTeacher_idAndTeacher_pwd(teacher_id, teacher_pwd);
			
			//�ж�
			if(teacher == null){
				throw new UserException("�û��������벻��ȷ");
			}
			
			return teacher;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("��½ʧ��");
		}
		
	}
	
	//����Ա
	public Admin AdminLogin(String admin_id,String admin_pwd)throws UserException{
		//��ѯ
		try {
			Admin Admin = adminAndTeacherDao.FindAdminByIdAndPwd(admin_id, admin_pwd);
			
			//�ж�
			if(Admin == null){
				throw new UserException("�û��������벻��ȷ");
			}
			
			return Admin;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("��½ʧ��");
		}
		
	}
}
