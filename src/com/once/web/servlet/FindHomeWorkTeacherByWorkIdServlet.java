package com.once.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.once.exception.UserException;
import com.once.model.Work;
import com.once.service.WorkService;


@WebServlet("/workinfo")
public class FindHomeWorkTeacherByWorkIdServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//获取请求参数
		String id = request.getParameter("works_id");
		String cid = request.getParameter("choice_id");
		String did = request.getParameter("discuss_id");
		//System.out.println(id);
		//调用service	
		WorkService ws = new WorkService();
		
		try {
			ws.DeleteChoiceByid(cid);
			ws.DeleteDiscussByid(did);
			Work work = ws.FindWorkByIdService(id);
			List<Work> choiceinfo = ws.FindChoiceWorkService(id);
			List<Work> discussinfo = ws.FindDiscussWorkService(id);
			//System.out.println(choiceinfo);
			request.getSession().setAttribute("choice", choiceinfo);
			request.getSession().setAttribute("discuss", discussinfo);
			request.getSession().setAttribute("workinfo", work);
			response.sendRedirect(request.getContextPath() + "/teacher/homeWorkInfo.jsp");
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/teacher/createHomework,jsp").forward(request, response);
		}
		
		}

}

