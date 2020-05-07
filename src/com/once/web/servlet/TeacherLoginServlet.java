package com.once.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.once.exception.UserException;
import com.once.model.Teacher;
import com.once.service.AdminAndTeacherService;


@WebServlet("/teacherlogin")
public class TeacherLoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//��ȡ�������
		String teacher_id = request.getParameter("teacher_id");
		String teacher_pwd = request.getParameter("teacher_pwd");
		//����service	
		AdminAndTeacherService ts = new AdminAndTeacherService();
		try {
			Teacher teacher = ts.Login(teacher_id, teacher_pwd);
			//��¼�ɹ�
			request.getSession().setAttribute("teacher_id", teacher.getTeacher_id());
			request.getSession().setAttribute("teacher_name", teacher.getTeacher_name());
			//request.getRequestDispatcher("/studentInfo.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/finduserinfo");
			
		} catch (UserException e) {
			e.printStackTrace();
			//��¼ʧ�ܣ��ص���¼ҳ��
			request.setAttribute("login_msg", e.getMessage());
			request.getRequestDispatcher("/teacher/login.jsp").forward(request, response);
			//response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
		
		}

	}

