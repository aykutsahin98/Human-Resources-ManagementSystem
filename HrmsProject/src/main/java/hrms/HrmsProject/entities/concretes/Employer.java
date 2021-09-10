package hrms.HrmsProject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@Data
@Entity
@Table(name = "employers")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","JobAdvertisement"})

public class Employer extends User{
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "website")
	private String webSite;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name="verification_status")
	private boolean verificationStatus;
	
	@Column(name = "waiting_update")
    private boolean waitingUpdate;

	
	
}