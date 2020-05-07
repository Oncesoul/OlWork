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
@WebServlet("/studentcomplet")
public class StudentCompletInfo extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		WorkService ws = new WorkService();
		
		String work_id = request.getParameter("work_id");
		String stu_id = request.getParameter("stu_id");
		String grade_stu_id = request.getParameter("stu_id");
		String stu_name = request.getParameter("stu_name");
		request.getSession().setAttribute("comstu_name", stu_name);
		try {
			List<Work> cwork = ws.FindCompletChioce(work_id, stu_id);
			//System.out.println(cwork);
			request.getSession().setAttribute("cwork", cwork);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			List<Work> dwork = ws.FindCompletDiscuss(work_id, stu_id);
			//System.out.println(dwork);
			request.getSession().setAttribute("dwork", dwork);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/teacher/studentCompletInfo.jsp");

}
}