package kg.gov.mf.loan.admin.org.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="organization")
public class Organization {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
 
    @Column(name="name", nullable=false)
    private String name;

    @Column(name="enabled")
    private boolean enabled;
    
    @Column(name="description")
    private String description;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name="identity_doc_id")
    IdentityDoc identityDoc;     

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name="address_id")
    Address address;      

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name="contact_id")
    Contact contact;      
    
    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<BankData> bankData = new HashSet<BankData>();    
    
    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Department> department = new HashSet<Department>();
    
    
    @ManyToOne(targetEntity=OrgForm.class, fetch = FetchType.LAZY)
    @JoinColumn(name="org_form_id")
    OrgForm orgForm; 
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public OrgForm getOrgForm() {
		return orgForm;
	}

	public void setOrgForm(OrgForm orgForm) {
		this.orgForm = orgForm;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public IdentityDoc getIdentityDoc() {
		return identityDoc;
	}

	public void setIdentityDoc(IdentityDoc identityDoc) {
		this.identityDoc = identityDoc;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<BankData> getBankData() {
		return bankData;
	}

	public void setBankData(Set<BankData> bankData) {
		this.bankData = bankData;
	}

	public Set<Department> getDepartment() {
		return department;
	}

	public void setDepartment(Set<Department> department) {
		this.department = department;
	}


	@Override
	public int hashCode() {
		int hash = 5;
		hash = 83 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) return true;
		if ( !(other instanceof Organization) ) return false;

		final Organization organization = (Organization) other;

		if(organization.getId() != getId()) return false;

		return true;
	}




}
