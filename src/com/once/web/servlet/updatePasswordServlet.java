package com.once.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.once.model.User;
import com.once.service.UserService;

@WebServlet("/updatepassword")
public class updatePasswordServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		//获取表单参数
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			//System.out.println(user);
			
			//修改
			String op = (String) request.getSession().getAttribute("oldPass");
			if(op.equals(user.getOld_password())){
				if(user.getStu_password().equals(user.getNewPassword())){
					UserService us = new UserService();
					us.updatePassword(user);
					response.sendRedirect(request.getContextPath() + "/updateUserPasswordSuccess.jsp");
				}
			}

			//跳转
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().write(e.getMessage());
		}
		//
	}

}
