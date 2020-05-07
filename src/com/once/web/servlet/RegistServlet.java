package com.once.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.once.exception.UserException;
import com.once.model.User;
import com.once.service.UserService;

@WebServlet("/register")
public class RegistServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//�Ѳ���ת��model
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			//System.out.println(user);
			//ע��
			UserService us = new UserService();
			us.register(user);
			
			//���ؽ��
			
			//�ɹ�-����ɹ�ҳ��
			response.sendRedirect(request.getContextPath() + "/finduserinfo");
			//request.getRequestDispatcher("/finduserinfo").forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
			//ʧ��-�ص�ע��ҳ��
			request.setAttribute("register_err", e.getMessage());
			request.getRequestDispatcher("/addFail.jsp").forward(request, response);
			System.out.println(e);
		}

	}
}
