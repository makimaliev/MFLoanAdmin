package kg.gov.mf.loan.admin.org.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="identity_doc")
public class IdentityDoc {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
 
    @Column(name="name", nullable=false)
    private String name;

    @Column(name="enabled")
    private boolean enabled;
    
    @Column(name="number", nullable=false)
    private String number;
    
    @Column(name="pin", nullable=false)
    private String pin;    
    
    @ManyToOne(targetEntity=IdentityDocType.class, fetch = FetchType.EAGER)
    @JoinColumn(name="identity_doc_type_id")
    IdentityDocType identityDocType;     
    
    @ManyToOne(targetEntity=IdentityDocGivenBy.class, fetch = FetchType.EAGER)
    @JoinColumn(name="identity_doc_given_by_id")
    IdentityDocGivenBy identityDocGivenBy;
    
    @DateTimeFormat(pattern = "dd.mm.yyyy")
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name="identity_doc_details_id")
    IdentityDocDetails identityDocDetails;     


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}



	public IdentityDocType getIdentityDocType() {
		return identityDocType;
	}

	public void setIdentityDocType(IdentityDocType identityDocType) {
		this.identityDocType = identityDocType;
	}

	public IdentityDocGivenBy getIdentityDocGivenBy() {
		return identityDocGivenBy;
	}

	public void setIdentityDocGivenBy(IdentityDocGivenBy identityDocGivenBy) {
		this.identityDocGivenBy = identityDocGivenBy;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public IdentityDocDetails getIdentityDocDetails() {
		return identityDocDetails;
	}

	public void setIdentityDocDetails(IdentityDocDetails identityDocDetails) {
		this.identityDocDetails = identityDocDetails;
	}

   
	
	
	
    
    
    
}
