package hrms.HrmsProject.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "activation_by_staff")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivationByPersonnel {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;

	    @Column(name = "employe_id")
	    private int employeId;

	    @Column(name = "staff_id")
	    private Integer staffId;

	    @Column(name = "verifyed")
	    private boolean verifyed;

	    @Column(name = "verify_date")
	    private LocalDate verifyDate;
}
