package kg.gov.mf.loan.admin.org.model;

import java.util.HashSet;
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
@Table(name="staff")

public class Staff {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
 
    @Column(name="name", nullable=false)
    private String name;


    @Column(name="enabled")
    private boolean enabled;  
    
    
    @ManyToOne(targetEntity=Department.class, fetch = FetchType.EAGER)
    @JoinColumn(name="department_id")
    Department department;
    
    @ManyToOne(targetEntity=Position.class, fetch = FetchType.EAGER)
    @JoinColumn(name="position_id")
    Position position;    
    
    @ManyToOne(targetEntity=Organization.class, fetch = FetchType.EAGER)
    @JoinColumn(name="organization_id")
    Organization organization;    
    
    @ManyToOne(targetEntity=Person.class, fetch = FetchType.EAGER)
    @JoinColumn(name="person_id")
    Person person;    
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name="employment_history_id")
    EmploymentHistory employmentHistory;     
    
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

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

	public EmploymentHistory getEmploymentHistory() {
		return employmentHistory;
	}

	public void setEmploymentHistory(EmploymentHistory employmentHistory) {
		this.employmentHistory = employmentHistory;
	}



	
    
    
}
