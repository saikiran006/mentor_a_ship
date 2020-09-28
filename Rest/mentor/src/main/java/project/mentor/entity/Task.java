package project.mentor.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Task")
public class Task {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long taskId;
	@Column
	private String name;
	@Column
	private int percentage;
	@Column
	private String assessment;
	@Column 
	private String notes;
	@Column 
	private Date assignedDate;
	@ManyToOne(fetch=FetchType.EAGER)
	private Associate associate;
	public Task() {}
	public Task(Long taskId, String name, int percentage, String assessment, String notes, Date assignedDate) {
		super();
		this.taskId = taskId;
		this.name = name;
		this.percentage = percentage;
		this.assessment = assessment;
		this.notes = notes;
		this.assignedDate = assignedDate;
	}
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public String getAssessment() {
		return assessment;
	}
	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Date getAssignedDate() {
		return assignedDate;
	}
	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}
	public Associate getAssociate() {
		return associate;
	}
	public void setAssociate(Associate associate) {
		this.associate = associate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assessment == null) ? 0 : assessment.hashCode());
		result = prime * result + ((assignedDate == null) ? 0 : assignedDate.hashCode());
		result = prime * result + ((associate == null) ? 0 : associate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + percentage;
		result = prime * result + ((taskId == null) ? 0 : taskId.hashCode());
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
		Task other = (Task) obj;
		if (assessment == null) {
			if (other.assessment != null)
				return false;
		} else if (!assessment.equals(other.assessment))
			return false;
		if (assignedDate == null) {
			if (other.assignedDate != null)
				return false;
		} else if (!assignedDate.equals(other.assignedDate))
			return false;
		if (associate == null) {
			if (other.associate != null)
				return false;
		} else if (!associate.equals(other.associate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (percentage != other.percentage)
			return false;
		if (taskId == null) {
			if (other.taskId != null)
				return false;
		} else if (!taskId.equals(other.taskId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", name=" + name + ", percentage=" + percentage + ", assessment=" + assessment
				+ ", notes=" + notes + ", assignedDate=" + assignedDate + ", associate=" + associate + "]";
	}
	
}
