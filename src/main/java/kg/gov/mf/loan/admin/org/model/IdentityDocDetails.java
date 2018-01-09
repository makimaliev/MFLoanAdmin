package kg.gov.mf.loan.admin.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="identity_doc_details")

public class IdentityDocDetails {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
 
    @Column(name="firstname", nullable=false)
    private String firstname;
    
    @Column(name="lastname", nullable=false)
    private String lastname;

    @Column(name="midname", nullable=false)
    private String midname;

    @Column(name="fullname", nullable=false)
    private String fullname;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identity_doc_id")
    private IdentityDoc identityDoc;    
    

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public IdentityDoc getIdentityDoc() {
		return identityDoc;
	}

	public void setIdentityDoc(IdentityDoc identityDoc) {
		this.identityDoc = identityDoc;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMidname() {
		return midname;
	}

	public void setMidname(String midname) {
		this.midname = midname;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

    

    
    
}
