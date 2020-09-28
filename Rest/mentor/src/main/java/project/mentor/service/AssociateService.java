package project.mentor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import project.mentor.entity.Associate;
import project.mentor.exception.BadRequestException;
import project.mentor.exception.NoSuchUserException;
import project.mentor.repository.AssociateRepository;
import project.mentor.repository.MentorRepository;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AssociateService {
	@Autowired
	private AssociateRepository repo;
	@Autowired
	private MentorRepository mentorrepo;
	@PostMapping("/associate")
	public Associate addMentor(@RequestParam(name = "name") String name,@RequestParam(name = "emailId") String emailId,
			@RequestParam(name = "password") String password,@RequestParam(name = "image") MultipartFile image,
			@RequestParam(name = "mentorEmailId") String mentorEmailId) {
		Associate associate=new Associate();
		associate.setName(name);
		associate.setEmailId(emailId);
		associate.setPassword(password);
		if(mentorrepo.findByEmailId(mentorEmailId)==null)
			throw new NoSuchUserException("Mentor Doesn't Exist");
		associate.setMentor(mentorrepo.findByEmailId(mentorEmailId));
		if(image!=null)
			associate.setAssociateImage(image);		
		if(repo.findByEmailId(emailId)!=null)
			throw new BadRequestException("Email Id already Registered");
		if(mentorrepo.findByEmailId(emailId)!=null) {
			throw new BadRequestException("Email Id registered as mentor");
		}
		return repo.add(associate);
	}
	
	@GetMapping("/associate/{emailId}")
	public Associate findByEmail(@PathVariable String emailId) {
			Associate a=repo.findByEmailId(emailId);
			if(a==null)
				throw new NoSuchUserException("User Does not Exist");
			return a;
	}
}
