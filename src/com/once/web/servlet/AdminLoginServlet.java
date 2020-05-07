package com.once.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.once.exception.UserException;
import com.once.model.Admin;
import com.once.model.Teacher;
import com.once.service.AdminAndTeacherService;


@WebServlet("/adminlogin")
public class AdminLoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//��ȡ�������
		String admin_id = request.getParameter("admin_id");
		String admin_pwd = request.getParameter("admin_pwd");
		//����service	
		AdminAndTeacherService as = new AdminAndTeacherService();
		try {
			Admin admin = as.AdminLogin(admin_id, admin_pwd);
			//System.out.println(admin);
			//��¼�ɹ�
			request.getSession().setAttribute("admin_id", admin.getAdmin_id());
			response.sendRedirect(request.getContextPath() + "/findteacherinfo");
			
		} catch (UserException e) {
			e.printStackTrace();
			//��¼ʧ�ܣ��ص���¼ҳ��
			request.setAttribute("login_msg", e.getMessage());
			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
			//response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
		
		}

	}

