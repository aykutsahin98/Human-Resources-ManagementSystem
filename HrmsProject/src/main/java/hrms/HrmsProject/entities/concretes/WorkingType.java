package hrms.HrmsProject.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="working_types")
public class WorkingType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;

	@Column(name = "type_name")
	private String typeName;
	
	@OneToMany(mappedBy = "workingType")
	@JsonIgnore()
	private List<JobAdvertisement> JobAdvertisements;
}
