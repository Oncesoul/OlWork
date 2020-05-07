package com.once.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.once.model.Answer;
import com.once.model.User;
import com.once.model.Work;
import com.once.utils.C3P0Utils;

public class WorkDao {
	
	public void addWork(Work work) throws SQLException{
		//��ȡQueryRunner
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		//sql
		String sql = "insert into work(works_id,works_title,works_content,work_tid) Values (?,?,?,?)";
		
		//����
		List<Object> list = new ArrayList<Object>();
		list.add(work.getWorks_id());
		list.add(work.getWorks_title());
		list.add(work.getWorks_content());
		list.add(work.getWork_tid());
		
		qr.update(sql,list.toArray());
	}
	
	//��ѯ��ҵ
	public List<Work> FindWorkByTid(String work_tid) throws SQLException{
		//��ȡQueryRunner
				QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		//sql
				String sql = "select * from work where work_tid = ?";
				List<Work> work = qr.query(sql, new BeanListHandler<Work>(Work.class),work_tid);
				
				return work;
	}
	
	//ɾ����ҵ
	public  void DeleteWorkByTid(String works_id) throws SQLException{
		//��ȡQueryRunner
				QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		//sql
				String sql = "DELETE FROM `work` WHERE works_id = ?";
				qr.update(sql,works_id);

	}
	
	
	//��ѯ��ҵ
	public Work FindWorkById(String works_id) throws SQLException{
		//��ȡQueryRunner
				QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		//sql
				String sql = "select * from work where works_id = ?";
				
				return qr.query(sql, new BeanHandler<Work>(Work.class),works_id);
	}
	
	/**
	 * ��ӵ���ѡ��
	 * @param work
	 * @throws SQLException
	 */
	public void AddWorkChioce(Work work) throws SQLException{
		//��ȡQueryRunner
				QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
				
				//sql
				String sql = "insert into choice(title,a,b,c,d,answer,work_id) Values (?,?,?,?,?,?,?)";
				
				//����
				List<Object> list = new ArrayList<Object>();
				list.add(work.getTitle());
				list.add(work.getA());
				list.add(work.getB());
				list.add(work.getC());
				list.add(work.getD());
				list.add(work.getAnswer());
				list.add(work.getWork_id());
				
				qr.update(sql,list.toArray());
	}
	
	/**
	 * ɾ����ѡ
	 * @param id
	 * @throws SQLException
	 */
	public  void DeleteChoiceByid(String id) throws SQLException{
		//��ȡQueryRunner
				QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		//sql
				String sql = "DELETE FROM `choice` WHERE id = ?";
				qr.update(sql,id);

	}
	
	/**
	 * ���������
	 * @param work
	 * @throws SQLException
	 */
	public void AddWorkDiscuss(Work work) throws SQLException{
		//��ȡQueryRunner
				QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
				
				//sql
				String sql = "insert into discuss(discuss_title,discuss_content,work_id) Values (?,?,?)";
				
				//����
				List<Object> list = new ArrayList<Object>();
				list.add(work.getDiscuss_title());
				list.add(work.getDiscuss_content());
				list.add(work.getWork_id());
				
				qr.update(sql,list.toArray());
	}
	
	/**
	 * ɾ������
	 * @param id
	 * @throws SQLException
	 */
	public  void DeleteDiscussByid(String discuss_id) throws SQLException{
		//��ȡQueryRunner
				QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		//sql
				String sql = "DELETE FROM `discuss` WHERE discuss_id = ?";
				qr.update(sql,discuss_id);

	}
	
	/**
	 * ��ѯ��ѡ
	 * @param work_tid
	 * @return
	 * @throws SQLException
	 */
	public List<Work> FindChoiceWorkByWorkId(String work_id) throws SQLException{
		//��ȡQueryRunner
				QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		//sql 
				String sql = "select * from choice where work_id = ?";
				List<Work> work = qr.query(sql, new BeanListHandler<Work>(Work.class),work_id);
				return work;
	}
	
	/**
	 * ��ѯ����
	 * @param work_id
	 * @return
	 * @throws SQLException
	 */
	public List<Work> FindDiscussWorkByWorkId(String work_id) throws SQLException{
		//��ȡQueryRunner
				QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		//sql	
				String sql = "select * from discuss where work_id = ?";
				List<Work> work = qr.query(sql, new BeanListHandler<Work>(Work.class),work_id);
				return work;
	}
	/**
	 * sql������ѯ������Ѵ������������
	 * @param answers
	 * @throws SQLException
	 */
	public void SubmitWork(Answer answers) throws SQLException{
		//��ȡQueryRunner
				QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
				
				//sql	INSERT INTO answer(stu_id, answer_id,answer) SELECT '122', '7','a' FROM DUAL WHERE NOT EXISTS(SELECT stu_id FROM answer WHERE stu_id=122 AND answer_id=7);
				String sql = "INSERT INTO answer(stu_id, answer_id,c_answer) SELECT ?, ?,? FROM DUAL WHERE NOT EXISTS(SELECT stu_id FROM answer WHERE stu_id=? AND answer_id=?)";
				
				//����
				List<Object> list = new ArrayList<Object>();
				//list.add(answers.getAnswer_id());
				list.add(answers.getStu_id());
				list.add(answers.getAnswer_id());
				list.add(answers.getAnswer());
				list.add(answers.getStu_id());
				list.add(answers.getAnswer_id());
				qr.update(sql,list.toArray());
	}
	
	public void SubmitDisWork(Answer answers) throws SQLException{
		//��ȡQueryRunner
				QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
				
				//sql	INSERT INTO answer(stu_id, answer_id,answer) SELECT '122', '7','a' FROM DUAL WHERE NOT EXISTS(SELECT stu_id FROM answer WHERE stu_id=122 AND answer_id=7);
				String sql = "INSERT INTO dis_answer(stu_id, answer_id,answer) SELECT ?, ?,? FROM DUAL WHERE NOT EXISTS(SELECT stu_id FROM dis_answer WHERE stu_id=? AND answer_id=?)";
				
				//����
				List<Object> list = new ArrayList<Object>();
				//list.add(answers.getAnswer_id());
				list.add(answers.getStu_id());
				list.add(answers.getAnswer_id());
				list.add(answers.getAnswer());
				list.add(answers.getStu_id());
				list.add(answers.getAnswer_id());
				qr.update(sql,list.toArray());
	}
	/**
	 * ��ѯ��ɵĵ�ѡ
	 * @param work_id
	 * @param stu_id
	 * @return
	 * @throws SQLException
	 */
	public List<Work> CompletChoice(String work_id,String stu_id) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "SELECT * FROM answer INNER JOIN choice ON choice.id = answer_id WHERE choice.work_id=? AND stu_id=?";
		
		List<Work> work = qr.query(sql, new BeanListHandler<Work>(Work.class),work_id,stu_id);
		
		return work;
	}
	/**
	 * ��ѯ��ɵ�����
	 * @param work_id
	 * @param stu_id
	 * @return
	 * @throws SQLException
	 */
	public List<Work> CompletDiscuss(String work_id,String stu_id) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		//SELECT * FROM dis_answer INNER JOIN discuss ON discuss.discuss_id = answer_id INNER JOIN grade ON grade.discuss_id = answer_id WHERE discuss.work_id=1 AND grade_stu_id=1
//		SELECT * FROM dis_answer INNER JOIN discuss ON discuss.discuss_id = answer_id INNER JOIN grade ON grade.discuss_id = answer_id WHERE discuss.work_id=1 AND grade_stu_id=1 AND stu_id=1
		String sql = "SELECT * FROM dis_answer INNER JOIN discuss ON discuss_id = answer_id WHERE discuss.work_id=? AND stu_id=?";
		
		List<Work> work = qr.query(sql, new BeanListHandler<Work>(Work.class),work_id,stu_id);
		
		return work;
	}
	public List<Work> DiscussAssess(String work_id,String grade_stu_id) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "SELECT * FROM grade INNER JOIN discuss ON grade.discuss_id = discuss.discuss_id WHERE work_id=? AND grade_stu_id=?";
		
		List<Work> work = qr.query(sql, new BeanListHandler<Work>(Work.class),work_id,grade_stu_id);
		
		return work;
	}
	
	public void AssessDisWork(Work works) throws SQLException{
		//��ȡQueryRunner
				QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
				
				//sql	INSERT INTO grade(grade,grade_stu_id,discuss_id,assess) SELECT 5, 121,4,'dsadsaa' FROM DUAL WHERE NOT EXISTS(SELECT grade_stu_id FROM grade WHERE grade_stu_id=121 AND discuss_id=4);
				String sql = "INSERT INTO grade(grade,grade_stu_id,discuss_id,assess) SELECT ?, ?,?,? FROM DUAL WHERE NOT EXISTS(SELECT grade_stu_id FROM grade WHERE grade_stu_id=? AND discuss_id=?)";
				
				//����
				List<Object> list = new ArrayList<Object>();
				
				list.add(works.getGrade());
				list.add(works.getGrade_stu_id());
				list.add(works.getDiscuss_id());
				list.add(works.getAssess());
				list.add(works.getGrade_stu_id());
				list.add(works.getDiscuss_id());
				
				qr.update(sql,list.toArray());
	}
}
