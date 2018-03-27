package au.com.octo.domain.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "APPLICATIONS")
public class Application {

	@Id
	@GeneratedValue(generator = "GEN_APPLICATION", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "GEN_APPLICATION", sequenceName = "SEC_APPLICATIONS", allocationSize = 1)
	public long id;

	@Column(name = "FORM_ID")
	public String formId;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATION_DATE")
	public Date creationDate;

	@Column(name = "TRACKING_NUMBER", nullable = false)
	public String trackingNumber;

	public Application(String formId , String trackingNumber) {
		this.formId = formId;
		this.trackingNumber = trackingNumber;
	}

	public Application() {
	}
}
