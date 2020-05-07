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

@WebServlet("/submithomework")
public class SubmitHomeWorkServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Answer answers = new Answer();
		WorkService ws = new WorkService();
		
		
		String i = request.getParameter("size");
		String j = request.getParameter("dissize");
		String sd = request.getParameter("stu_id");
		
		
		if(i != null & j != null){
			int	stuid = Integer.parseInt(sd);
			int size = Integer.parseInt(i);
			int dissize = Integer.parseInt(j);
			for(int a=0;a<size;a++){
				String ad = request.getParameter("answer_id"+a);
				String answer = request.getParameter("answer"+a);
				
				
				int answer_id = Integer.parseInt(ad);
				
				answers.setAnswer_id(answer_id);
				answers.setStu_id(stuid);
				answers.setAnswer(answer);
				
				//System.out.println(answers);
				try {
					ws.SubmitWorkService(answers);
					
				} catch (UserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//response.sendRedirect(request.getContextPath() + "/homeWorkInfo.jsp");
				}
			
			}
			
			for(int b = 0;b<dissize;b++){
				String ad = request.getParameter("disanswer_id"+b);
				String answer = request.getParameter("disanswer"+b);
				
				int disanswer_id = Integer.parseInt(ad);
				
				answers.setAnswer(answer);
				answers.setAnswer_id(disanswer_id);
				answers.setStu_id(stuid);
				
				//System.out.println(answers);
				try {
					ws.SubmitDisWorkService(answers);
				} catch (UserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		
//		
		//Work work = new Work();
		
		String work_id = request.getParameter("work_id");
		String stu_id = request.getParameter("stu_id");
		String grade_stu_id = request.getParameter("stu_id");
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
		
		try {
			List<Work> disassess = ws.FindDiscussAssess(work_id, grade_stu_id);
			request.getSession().setAttribute("disassess", disassess);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/completedHomeWork.jsp");
		
//		try {
//			BeanUtils.populate(answer, request.getParameterMap());
//			System.out.println(answer);
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
}
}