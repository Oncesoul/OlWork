package com.once.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.once.exception.UserException;
import com.once.model.User;
import com.once.service.UserService;


@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//��ȡ�������
		String stu_id = request.getParameter("stu_id");
		String stu_password = request.getParameter("stu_password");
		//����service	
		UserService us = new UserService();
		try {
			User user = us.Login(stu_id, stu_password);
			//��¼�ɹ�
			//String userid = stu_id;
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("oldPass", stu_password);
			//request.getRequestDispatcher("/studentInfo.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/work.jsp");
			
		} catch (UserException e) {
			e.printStackTrace();
			//��¼ʧ�ܣ��ص���¼ҳ��
			request.setAttribute("login_msg", e.getMessage());
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			//response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
		
		}

	}

