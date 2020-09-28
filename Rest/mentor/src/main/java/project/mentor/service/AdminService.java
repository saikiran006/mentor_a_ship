package project.mentor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import project.mentor.entity.Admin;
import project.mentor.exception.NoSuchUserException;
import project.mentor.repository.AdminRepository;
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AdminService {
	@Autowired
	AdminRepository repo;
	
	@GetMapping("/admin/{emailId}")
	public Admin findByEmail(@PathVariable String emailId) {
			Admin admin=repo.findByEmailId(emailId);
			if(admin==null)
				throw new NoSuchUserException("User Does not Exist");
			return admin;
	}
}
