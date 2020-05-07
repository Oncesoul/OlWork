package com.once.service;

import java.sql.SQLException;
import java.util.List;

import com.once.DAO.WorkDao;
import com.once.exception.UserException;
import com.once.model.Answer;
import com.once.model.User;
import com.once.model.Work;

public class WorkService {
	WorkDao workDao = new WorkDao();
	
	public void addWork(Work work) throws UserException{
		try {
			workDao.addWork(work);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("×÷ÒµÌí¼ÓÊ§°Ü£¡");
		}
	}
	
	public List<Work> FindWorkService(String work_tid) throws UserException{
		try {
			List<Work> work = workDao.FindWorkByTid(work_tid);
			return work;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("²éÑ¯Ê§°Ü");
		}
	}
	
	public void DeleteWorkByid(String works_id) throws UserException{
		try {
			workDao.DeleteWorkByTid(works_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("É¾³ýÊ§°Ü");
		}
	}
	
	public void DeleteChoiceByid(String id) throws UserException{
		try {
			workDao.DeleteChoiceByid(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("É¾³ýÊ§°Ü");
		}
	}
	
	public void DeleteDiscussByid(String discuss_id) throws UserException{
		try {
			workDao.DeleteDiscussByid(discuss_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("É¾³ýÊ§°Ü");
		}
	}
	
	public Work FindWorkByIdService(String works_id) throws UserException{
		try {
			Work work = workDao.FindWorkById(works_id);
			return work;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("²éÑ¯Ê§°Ü");
		}
	}
	
	public void AddWorkChoiceService(Work work) throws UserException{
		try {
			workDao.AddWorkChioce(work);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("×÷ÒµÌí¼ÓÊ§°Ü£¡");
		}
	}
	
	public void AddWorkDiscussService(Work work) throws UserException{
		try {
			workDao.AddWorkDiscuss(work);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("×÷ÒµÌí¼ÓÊ§°Ü£¡");
		}
	}
	
	public List<Work> FindChoiceWorkService(String work_id) throws UserException{
		try {
			List<Work> work = workDao.FindChoiceWorkByWorkId(work_id);
			return work;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("²éÑ¯Ê§°Ü");
		}
	}
	
	public List<Work> FindDiscussWorkService(String work_id) throws UserException{
		try {
			List<Work> work = workDao.FindDiscussWorkByWorkId(work_id);
			return work;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("²éÑ¯Ê§°Ü");
		}
	}
	
	public void SubmitWorkService(Answer answers) throws UserException{
		try {
			workDao.SubmitWork(answers);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("×÷ÒµÌá½»Ê§°Ü£¡");
		}
	}
	
	public void SubmitDisWorkService(Answer answers) throws UserException{
		try {
			workDao.SubmitDisWork(answers);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("×÷ÒµÌá½»Ê§°Ü£¡");
		}
	}
	
	public List<Work> FindCompletChioce(String work_id,String stu_id) throws UserException{
		try {
			List<Work> work = workDao.CompletChoice(work_id, stu_id);
			return work;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("²éÑ¯Ê§°Ü£¡");
		}
	}
	
	public List<Work> FindCompletDiscuss(String work_id,String stu_id) throws UserException{
		try {
			List<Work> work = workDao.CompletDiscuss(work_id, stu_id);
			return work;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("²éÑ¯Ê§°Ü£¡");
		}
	}
	public List<Work> FindDiscussAssess(String work_id,String grade_stu_id) throws UserException{
		try {
			List<Work> work = workDao.DiscussAssess(work_id, grade_stu_id);
			return work;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("²éÑ¯Ê§°Ü£¡");
		}
	}
	
	public void AssessDisWorkService(Work works) throws UserException{
		try {
			workDao.AssessDisWork(works);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
