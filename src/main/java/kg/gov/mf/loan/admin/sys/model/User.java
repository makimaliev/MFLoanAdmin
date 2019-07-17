package kg.gov.mf.loan.admin.sys.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import kg.gov.mf.loan.admin.org.model.GenericModelAdmin;
import kg.gov.mf.loan.admin.org.model.Staff;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="users")
public class User extends GenericModelAdmin {

 
    @Column(name="username", unique=true, nullable=false)
    private String username;
     
    @Column(name="password", nullable=false)
    private String password;
    
    @Column(name="enabled")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = { 
			@JoinColumn(name = "user_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "role_id", 
					nullable = false, updatable = false) })
    private Set<Role> roles = new HashSet<Role>(0);
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_supervisor_term", joinColumns = { 
			@JoinColumn(name = "user_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "supervisor_term_id", 
					nullable = false, updatable = false) })
    private Set<SupervisorTerm> supervisorTerms = new HashSet<SupervisorTerm>(0);

	@JsonManagedReference
	@OneToOne(targetEntity=Staff.class, fetch = FetchType.EAGER)
	@JoinColumn(name="staff_id")
	Staff staff;



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Set<SupervisorTerm> getSupervisorTerms() {
		return supervisorTerms;
	}

	public void setSupervisorTerms(Set<SupervisorTerm> supervisorTerms) {
		this.supervisorTerms = supervisorTerms;
	}

	@Override
	public String toString() {
		return "User [id=" + super.getId() + ", username=" + username + ", password=" + password + ", enabled=" + enabled;
	}

	
	@Override
	public int hashCode() {
		int hash = 5;
		hash = 83 * hash + Objects.hashCode(super.getId());
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
//		if (getClass() != obj.getClass()) {
//			return false;
//		}
		final User other = (User) obj;
		if (!Objects.equals(this.getId(), other.getId())) {
			return false;
		}
		return true;
	}
    
    
}
