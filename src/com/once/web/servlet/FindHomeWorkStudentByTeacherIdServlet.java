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


@WebServlet("/findhomework")
public class FindHomeWorkStudentByTeacherIdServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//获取请求参数
		String tid = request.getParameter("teacher_id");
		//System.out.println(tid);
		//调用service	
		WorkService ws = new WorkService();
		
		try {
			List<Work> work = ws.FindWorkService(tid);
			//System.out.println(work);
			
			request.getSession().setAttribute("findhomework", work);
			response.sendRedirect(request.getContextPath() + "/work.jsp");
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/work,jsp").forward(request, response);
		}
		
		}

	}

