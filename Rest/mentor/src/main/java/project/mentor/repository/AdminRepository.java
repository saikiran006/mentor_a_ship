package project.mentor.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project.mentor.entity.Admin;
@Transactional
@Component
public class AdminRepository {
	@Autowired
	private EntityManager em;
	
	public Admin findByEmailId(String emailId) {
		Query q=em.createNativeQuery("Select *from Admin where email_id= :emailId",Admin.class);
				q.setParameter("emailId", emailId);
				try {
					
					return (Admin) q.getSingleResult();
				}
				catch (Exception e) {
					return null;
				}
		
	}
}
