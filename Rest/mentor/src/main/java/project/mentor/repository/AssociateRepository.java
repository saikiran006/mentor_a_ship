package project.mentor.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project.mentor.entity.Associate;
@Component
@Transactional
public class AssociateRepository {
	@Autowired
	private EntityManager em;
	@SuppressWarnings("unchecked")
	public Associate findByEmailId(String emailId) {
		Query q=em.createNativeQuery("Select * from associate where email_id= :emailId",Associate.class);
				q.setParameter("emailId", emailId);
				try {
					return (Associate)q.getSingleResult();

				}
				catch (Exception e) {
					return null;
				}
		
	}
	public Associate add(Associate associate) {
		em.persist(associate);
		return associate;
	}
}
