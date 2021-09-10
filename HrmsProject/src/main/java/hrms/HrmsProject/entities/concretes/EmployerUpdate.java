package hrms.HrmsProject.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employer_update")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerUpdate {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;

	    @Column(name = "company_name")
	    private String companyName;
	    
	    @Column(name = "email")
	    private String email;
	    
	    @Column(name = "employer_id")
	    private Integer employerId;
	    
	    @JsonIgnore
	    @Column(name = "staff_id")
	    private Integer staffId;
	    
	    @Column(name = "phone_number")
	    private String phoneNumber;

	    @Column(name = "web_site")
	    private String webSite;

	    @JsonIgnore
	    @Column(name = "create_day")
	    private LocalDate createDay;

	    @JsonIgnore
	    @Column(name = "verifyed")
	    private boolean verifyed;

	    @JsonIgnore
	    @Column(name = "verify_date")
	    private LocalDate verifyDate;
}
