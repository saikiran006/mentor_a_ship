package project.mentor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import project.mentor.entity.Associate;
import project.mentor.entity.Mentor;
import project.mentor.exception.BadRequestException;
import project.mentor.exception.NoSuchUserException;
import project.mentor.repository.AssociateRepository;
import project.mentor.repository.MentorRepository;
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class MentorService {
	@Autowired
	private MentorRepository repo;
	@Autowired 
	private AssociateRepository associaterepo;
	@PostMapping("/mentor")
	public Mentor addMentor(@RequestParam(name = "name") String name,@RequestParam(name = "emailId") String emailId,
			@RequestParam(name = "password") String password,@RequestParam(name = "organization") String organization,
			@RequestParam(name = "role") String role,@RequestParam(name = "areaOfInterest") String areaOfInterest,
			@RequestParam(name = "expertise") String expertise,@RequestParam(name = "image") MultipartFile image) {
		Mentor mentor=new Mentor();
		mentor.setName(name);
		mentor.setEmailId(emailId);
		mentor.setPassword(password);
		mentor.setOrganization(organization);
		mentor.setRole(role);
		mentor.setAreaOfInterest(areaOfInterest);
		mentor.setExpertise(expertise);
		if(image!=null)
			mentor.setMentorImage(image);		
		if(repo.findByEmailId(emailId)!=null){
			throw new BadRequestException("Email Id already Registered");
		}
		if(associaterepo.findByEmailId(emailId)!=null) {
			throw new BadRequestException("Email Id registered as associate");
		}
		return repo.add(mentor);
	}
	
	@GetMapping("/mentor/{emailId}")
	public Mentor findByEmail(@PathVariable String emailId) {
			Mentor m=repo.findByEmailId(emailId);
			if(m==null)
				throw new NoSuchUserException("User Does not Exist");
			return m;
	}
	
	//get associates by mentor emailId
	@GetMapping("m/associates/{emailId}")
	public List<Associate> getAssociates(@PathVariable String emailId){
		Long id=repo.getIdByEmail(emailId);
		return repo.getAssociatesOfMentor(id);
	}
}
