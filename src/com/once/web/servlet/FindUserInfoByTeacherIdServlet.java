package com.once.web.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.once.exception.UserException;
import com.once.model.Teacher;
import com.once.model.User;
import com.once.service.AdminAndTeacherService;
import com.once.service.UserService;


@WebServlet("/finduserinfo")
public class FindUserInfoByTeacherIdServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//获取请求参数
		Integer stu_tid = (Integer) request.getSession().getAttribute("teacher_id");
		String st = stu_tid.toString();
		//System.out.println(st);
		//调用service	
		UserService us = new UserService();
		try {
			List<User> user = us.UserInfo(st);
			//System.out.println(user);
//			for(User u : user){
//				System.out.println(u);
//			}
			//System.out.println(user);
			request.getSession().setAttribute("userinfo", user);
			response.sendRedirect(request.getContextPath() + "/teacher/addstudent.jsp");
			//request.getRequestDispatcher("/teacher/addstudent.jsp").forward(request, response);
		} catch (UserException e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/teacher/login.jsp");
		}
		
		}

	}

