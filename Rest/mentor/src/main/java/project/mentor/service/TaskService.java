package project.mentor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project.mentor.entity.Associate;
import project.mentor.entity.Task;
import project.mentor.repository.AssociateRepository;
import project.mentor.repository.TaskRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")

public class TaskService {
	@Autowired
	private TaskRepository repo;
	@Autowired
	private AssociateRepository associaterepo;
	@GetMapping("tasks/{emailId}")
	public List<Task> getTasks(@PathVariable String emailId){
		return repo.getTasksForAssociate(emailId);
	}
	
	@PostMapping("task/{id}")
	public void updateTask(@PathVariable Long id,@RequestBody int percent) {
		repo.update(id,percent);
	}
	@DeleteMapping("task/{id}")
	public void deleteById(@PathVariable Long id) {
		repo.delete(id);
	}
	@PostMapping("task/add/{emailId}")
	public void addTask(@PathVariable String emailId,@RequestBody Task task) {
		Associate a=associaterepo.findByEmailId(emailId);
		task.setAssociate(a);
		repo.addNewTask(task);
	}
}
