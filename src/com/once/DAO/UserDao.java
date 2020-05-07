package com.once.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.once.model.Teacher;
import com.once.model.User;
import com.once.utils.C3P0Utils;

public class UserDao {
	/**
	 * 添加一个用户
	 * @param user
	 * @throws SQLException 
	 */
	public void addUser(User user) throws SQLException{
		//获取QueryRunner
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		//sql
		String sql = "insert into student (stu_id,stu_name,stu_tid) Values(?,?,?)";
		//参数
		List<Object> list = new ArrayList<Object>();
		list.add(user.getStu_id());
		list.add(user.getStu_name());
		list.add(user.getStu_tid());
		//执行
		qr.update(sql,list.toArray());
	}
	
	public void addTeacher(Teacher teacher) throws SQLException{
		//获取QueryRunner
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		//sql
		String sql = "insert into teacher (teacher_id,teacher_name,teacher_pwd) Values(?,?,?)";
		//参数
		List<Object> list = new ArrayList<Object>();
		list.add(teacher.getTeacher_id());
		list.add(teacher.getTeacher_name());
		list.add(teacher.getTeacher_pwd());
		//执行
		qr.update(sql,list.toArray());
	}
	
	public User findUserByStu_idAndstu_password(String stu_id,String stu_password) throws SQLException{
		//获取QueryRunner
				QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
				//sql
				String sql = "select * from student where stu_id = ? and stu_password = ?";
				return qr.query(sql, new BeanHandler<User>(User.class),stu_id,stu_password);
	}
	
	
	/**
	 * 修改学生密码
	 * @param user
	 * @throws SQLException
	 */
	public void updatePassword(User user) throws SQLException{
		//获取QueryRunner
				QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
				//sql
				String sql = "update student set stu_password = ? where stu_id = ?";
				qr.update(sql,user.getStu_password(),user.getStu_id());
	}
	
	/**
	 * 通过教师id查询学生信息
	 * @param stu_tid
	 * @return
	 * @throws SQLException
	 */
	public List<User> findUserByTeacher(String stu_tid) throws SQLException{
		//获取QueryRunner
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		//sql
		String sql = "select * from student where stu_tid = ?";
		
		List<User> user = qr.query(sql, new BeanListHandler<User>(User.class),stu_tid);
		return user;
	}
	
	public List<Teacher> findTeacher() throws SQLException{
		//获取QueryRunner
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		//sql
		String sql = "select * from teacher";
		
		List<Teacher> teacher = qr.query(sql, new BeanListHandler<Teacher>(Teacher.class));
		return teacher;
	}
}