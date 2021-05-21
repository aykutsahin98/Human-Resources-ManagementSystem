package hrms.HrmsProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="job_titles")
public class JobTittle {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="job_name")
	private String job_name;

	public JobTittle() {
		// TODO Auto-generated constructor stub
	}

	public JobTittle(int id, String job_name) {
		super();
		this.id = id;
		this.job_name = job_name;
	}

}
