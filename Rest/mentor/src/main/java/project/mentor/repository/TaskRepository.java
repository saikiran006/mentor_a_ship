package project.mentor.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project.mentor.entity.Task;
@Component
@Transactional
public class TaskRepository {
	@Autowired
	private EntityManager em;
	//tasks assigned to associates
	@SuppressWarnings("unchecked")
	public List<Task> getTasksForAssociate(String emailId){
		Query q=em.createNativeQuery("select *from task where associate_associate_id in "
				+ "(select associate_id from associate where email_id=:emailId)");
		q.setParameter("emailId",emailId);
		return q.getResultList();
	}
	
	public void update(Long id, int percent){
		Task task=em.find(Task.class, id);		
		task.setPercentage(percent);	
		em.persist(task);
	}
	
	public void delete(Long id) {
		Task task=em.find(Task.class, id);
		em.remove(task);
	}
	
	public void addNewTask(Task task) {
		em.persist(task);
	}
}
