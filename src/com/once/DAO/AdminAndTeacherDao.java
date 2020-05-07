package com.once.DAO;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.once.model.Teacher;
import com.once.model.Admin;
import com.once.utils.C3P0Utils;

public class AdminAndTeacherDao {
	/**
	 * 教师登录
	 * @param teacher_id
	 * @param teacher_pwd
	 * @return
	 * @throws SQLException
	 */
	public Teacher findTeacherByTeacher_idAndTeacher_pwd(String teacher_id,String teacher_pwd) throws SQLException{
		//获取QueryRunner
				QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
				//sql
				String sql = "select * from teacher where teacher_id = ? and teacher_pwd = ?";
				return qr.query(sql, new BeanHandler<Teacher>(Teacher.class),teacher_id,teacher_pwd);
	}
	
//	public Teacher findUserByTeacher_id(String teacher_id) throws SQLException{
//		//获取QueryRunner
//				QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
//				//sql
//				String sql = "select * from student where stu_tid = ?";
//				return qr.query(sql, new BeanHandler<Teacher>(Teacher.class),teacher_id);
//	}
	
	
	public Admin FindAdminByIdAndPwd(String admin_id,String admin_pwd) throws SQLException{
		//获取QueryRunner
				QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
				//sql
				String sql = "select * from admin where admin_id = ? and admin_pwd = ?";
				return qr.query(sql, new BeanHandler<Admin>(Admin.class),admin_id,admin_pwd);
	}
	

}
