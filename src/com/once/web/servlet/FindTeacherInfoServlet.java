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


@WebServlet("/findteacherinfo")
public class FindTeacherInfoServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//µ÷ÓÃservice	
		UserService us = new UserService();
		try {
			List<Teacher> teacher = us.TeacherInfo();
			//System.out.println(user);
//			for(User u : user){
//				System.out.println(u);
//			}
			//System.out.println(user);
			request.getSession().setAttribute("teacherinfo", teacher);
			response.sendRedirect(request.getContextPath() + "/admin/addTeacher.jsp");
			//request.getRequestDispatcher("/teacher/addstudent.jsp").forward(request, response);
		} catch (UserException e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
		}
		
		}

	}

