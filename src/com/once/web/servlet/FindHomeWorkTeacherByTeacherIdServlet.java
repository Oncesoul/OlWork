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
import com.once.model.Work;
import com.once.service.AdminAndTeacherService;
import com.once.service.UserService;
import com.once.service.WorkService;


@WebServlet("/findwork")
public class FindHomeWorkTeacherByTeacherIdServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//获取请求参数
		Integer work_tid = (Integer) request.getSession().getAttribute("teacher_id");
		String wt = work_tid.toString();
		String works_id = request.getParameter("works_id");
		
		//System.out.println(st);
		//调用service	
		WorkService ws = new WorkService();
		try {
			ws.DeleteWorkByid(works_id);
			List<Work> work = ws.FindWorkService(wt);
			//System.out.println(work);
			request.getSession().setAttribute("findwork", work);
			response.sendRedirect(request.getContextPath() + "/teacher/createHomework.jsp");
			//request.getRequestDispatcher("/teacher/addstudent.jsp").forward(request, response);
		} catch (UserException e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/teacher/login.jsp");
		}
		
		}

	}

