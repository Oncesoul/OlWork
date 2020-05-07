package com.once.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.once.exception.UserException;
import com.once.model.Answer;
import com.once.model.Work;
import com.once.service.WorkService;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@WebServlet("/assessdiswork")
public class AssessDisWorkServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Work works = new Work();
		WorkService ws = new WorkService();
		
		
		String j = request.getParameter("dissize");
		int dissize = Integer.parseInt(j);
		
		for(int b = 0;b<dissize;b++){
			String gd = request.getParameter("grade"+b);
			int grade = Integer.parseInt(gd);
			String assess = request.getParameter("assess"+b);
			
			String sd = request.getParameter("gs_id");
			int grade_stu_id = Integer.parseInt(sd);
			
			String dd = request.getParameter("dis_id"+b);
			int discuss_id = Integer.parseInt(dd);
			
			works.setDiscuss_id(discuss_id);
			works.setGrade_stu_id(grade_stu_id);
			works.setGrade(grade);
			works.setAssess(assess);
			
			try {
				ws.AssessDisWorkService(works);
				//request.getRequestDispatcher("/teacher/creatHomeWork.jsp").forward(request, response);
			} catch (UserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//request.getRequestDispatcher("/teacher/creatHomeWork.jsp").forward(request, response);
			}
		}
		response.sendRedirect(request.getContextPath() + "/teacher/createHomework.jsp");
}
}