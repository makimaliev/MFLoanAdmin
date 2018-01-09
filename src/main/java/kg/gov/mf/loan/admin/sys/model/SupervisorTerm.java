package kg.gov.mf.loan.admin.sys.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import kg.gov.mf.loan.admin.org.model.*;

 
@Entity
@Table(name="supervisor_term")
public class SupervisorTerm {
 
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Column(name="name")
    private String name;

    @ManyToOne(targetEntity=Region.class, fetch = FetchType.EAGER)
    @JoinColumn(name="region_id")
    Region region; 
    
    @ManyToOne(targetEntity=District.class, fetch = FetchType.EAGER)
    @JoinColumn(name="district_id")
    District district; 

    @ManyToOne(targetEntity=Department.class, fetch = FetchType.EAGER)
    @JoinColumn(name="department_id")
    Department department;
    
    @Column(name="debtor_type_id")
    private long debtor_type_id;

    @Column(name="wotk_sector_id")
    private long work_sector_id;
    
    
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "supervisorTerms")
    private Set<User> users = new HashSet<User>(0);
    
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}
	

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public long getDebtor_type_id() {
		return debtor_type_id;
	}

	public void setDebtor_type_id(long debtor_type_id) {
		this.debtor_type_id = debtor_type_id;
	}

	public long getWork_sector_id() {
		return work_sector_id;
	}

	public void setWork_sector_id(long work_sector_id) {
		this.work_sector_id = work_sector_id;
	}

    
}


