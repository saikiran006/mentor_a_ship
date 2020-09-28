package project.mentor.entity;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Mentor")
public class Mentor {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long mentorId;	
	@Column
	private String name;
	@Column(unique=true)
	private String emailId;
	@Column
	private String password;
	@Column
	private String organization;
	@Column
	private String role;
	@Column
	private String areaOfInterest;
	@Column
	private String expertise;
	@Column
	@Lob
	private byte[] mentorImage;
	@JsonIgnore
	@OneToMany(mappedBy="mentor", fetch = FetchType.LAZY)
	private List<Associate> associates;
	
	public byte[] getMentorImage() {
		return mentorImage;
	}
	public void setMentorImage(MultipartFile mentorImage) {
		try {
			this.mentorImage = mentorImage.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void addAssociates(Associate associte) {
		 associates.add(associte);
	}
	public void removeAssociates(Associate associate) {
		associates.remove(associate);
	}
	
	public Mentor() {}
	
	public Mentor(Long mentorId, String name, String emailId, String password, String organization, String role,
			String areaOfInterest, String expertise, byte[] mentorImage) {
		super();
		this.mentorId = mentorId;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.organization = organization;
		this.role = role;
		this.areaOfInterest = areaOfInterest;
		this.expertise = expertise;
		this.mentorImage = mentorImage;
	}
	public Long getMentorId() {
		return mentorId;
	}
	public void setMentorId(Long mentorId) {
		this.mentorId = mentorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAreaOfInterest() {
		return areaOfInterest;
	}
	public void setAreaOfInterest(String areaOfInterest) {
		this.areaOfInterest = areaOfInterest;
	}
	
	
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaOfInterest == null) ? 0 : areaOfInterest.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((expertise == null) ? 0 : expertise.hashCode());
		result = prime * result + ((mentorId == null) ? 0 : mentorId.hashCode());
		result = prime * result + Arrays.hashCode(mentorImage);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((organization == null) ? 0 : organization.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mentor other = (Mentor) obj;
		if (areaOfInterest == null) {
			if (other.areaOfInterest != null)
				return false;
		} else if (!areaOfInterest.equals(other.areaOfInterest))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (expertise == null) {
			if (other.expertise != null)
				return false;
		} else if (!expertise.equals(other.expertise))
			return false;
		if (mentorId == null) {
			if (other.mentorId != null)
				return false;
		} else if (!mentorId.equals(other.mentorId))
			return false;
		if (!Arrays.equals(mentorImage, other.mentorImage))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (organization == null) {
			if (other.organization != null)
				return false;
		} else if (!organization.equals(other.organization))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Mentor [mentorId=" + mentorId + ", name=" + name + ", emailId=" + emailId + ", password=" + password
				+ ", organization=" + organization + ", role=" + role + ", areaOfInterest=" + areaOfInterest
				+ ", expertise=" + expertise + ", mentorImage=" + Arrays.toString(mentorImage) + ", associates="
				+ associates + "]";
	}
	
}
