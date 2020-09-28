package project.mentor.repository;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project.mentor.entity.Associate;
import project.mentor.entity.Mentor;

@Component
@Transactional
public class MentorRepository {
	@Autowired
	private EntityManager em;
	@SuppressWarnings("unchecked")
	public Mentor findByEmailId(String emailId) {
		Query q=em.createNativeQuery("Select *from mentor where email_id= :emailId",Mentor.class);
				q.setParameter("emailId", emailId);
				try {
					return (Mentor) q.getSingleResult();
				}
				catch (Exception e) {
					return null;
				}
		
	}
	public Mentor add(Mentor mentor) {
		em.persist(mentor);
		return mentor;
	}
	
	public Long getIdByEmail(String emailId) {
		Query q=em.createNativeQuery("select mentor_id from mentor where email_id=:emailId");
		q.setParameter("emailId", emailId);
		return ((BigInteger) q.getSingleResult()).longValue();
	}
	
	@SuppressWarnings("unchecked")
	public List<Associate> getAssociatesOfMentor(Long id) {
		Query q=em.createNativeQuery("select *from associate where mentor_mentor_id=:mentorid");
		q.setParameter("mentorid",id);
		return q.getResultList();
	}
}
