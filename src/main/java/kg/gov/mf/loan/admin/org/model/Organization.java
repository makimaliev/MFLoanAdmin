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
public class Organization extends BaseEntity {
 
    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<BankData> bankData = new HashSet<BankData>();    
    
    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Department> department = new HashSet<Department>();
    
    
    @ManyToOne(targetEntity=OrgForm.class, fetch = FetchType.EAGER)
    @JoinColumn(name="org_form_id")
    OrgForm orgForm; 
    
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

	public OrgForm getOrgForm() {
		return orgForm;
	}

	public void setOrgForm(OrgForm orgForm) {
		this.orgForm = orgForm;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 83 * hash + Objects.hashCode(this.getId());
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
