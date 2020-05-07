package com.once.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.soap.AddressingFeature.Responses;

import org.apache.commons.beanutils.BeanUtils;

import com.once.model.Work;
import com.once.service.WorkService;

@WebServlet("/addchoice")
public class AddWorkChoiceServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//把参数转成model
		Work work = new Work();
		try {
			BeanUtils.populate(work, request.getParameterMap());
			//System.out.println(work);
			
			WorkService ws = new WorkService();
			ws.AddWorkChoiceService(work);
			
			response.sendRedirect(request.getContextPath() + "/teacher/homeWorkInfo.jsp");
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/teacher/homeWorkInfo.jsp").forward(request, response);
		}
	}
}
