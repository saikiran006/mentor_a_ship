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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Associate")
public class Associate {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long associateId;	
	@Column
	private String name;
	@Column(unique=true)
	private String emailId;
	@Column
	private String password;
	@Column
	@Lob
	private byte[] associateImage;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Mentor mentor;
	
	@OneToMany(mappedBy="associate", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Task> tasks;
	
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public Associate() {}
	public Associate(Long associateId, String name, String emailId, String password, byte[] associateImage) {
		super();
		this.associateId = associateId;
		this.name = name;
		this.emailId = emailId;
		this.password = password;
		this.associateImage = associateImage;
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
	
	public byte[] getAssociateImage() {
		return associateImage;
	}
	public void setAssociateImage(MultipartFile associateImage) {
		try {
			this.associateImage = associateImage.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Long getAssociateId() {
		return associateId;
	}
	public void setAssociateId(Long associateId) {
		this.associateId = associateId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Mentor getMentor() {
		return mentor;
	}
	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((associateId == null) ? 0 : associateId.hashCode());
		result = prime * result + Arrays.hashCode(associateImage);
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((tasks == null) ? 0 : tasks.hashCode());
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
		Associate other = (Associate) obj;
		if (associateId == null) {
			if (other.associateId != null)
				return false;
		} else if (!associateId.equals(other.associateId))
			return false;
		if (!Arrays.equals(associateImage, other.associateImage))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (tasks == null) {
			if (other.tasks != null)
				return false;
		} else if (!tasks.equals(other.tasks))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Associate [associateId=" + associateId + ", name=" + name + ", emailId=" + emailId + ", password="
				+ password + ", associateImage=" + Arrays.toString(associateImage) + ", tasks=" + tasks + "]";
	}
	
}
