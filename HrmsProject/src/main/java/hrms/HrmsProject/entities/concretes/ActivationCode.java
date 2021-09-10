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
@Table(name = "activation_codes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivationCode {

	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;

	    @Column(name = "user_id")
	    private int userId;

	    @Column(name = "code")
	    private String code;

	    @Column(name = "verifayed")
	    private boolean verifayed;

	    @Column(name = "verify_date")
	    private LocalDate verifyDate;
}
