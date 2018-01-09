package kg.gov.mf.loan.admin.org.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="employmentHistory")

public class EmploymentHistory {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
 
    @Column(name="number")
    private String number;
    
    @DateTimeFormat(pattern = "dd.mm.yyyy")
    @Temporal(TemporalType.DATE)
    private Date date;    
    
    @OneToOne(targetEntity=Staff.class, fetch = FetchType.EAGER)
    @JoinColumn(name="staff_id")
    Staff staff;    
    
    @OneToMany(mappedBy = "employmentHistory", cascade = CascadeType.MERGE, fetch = FetchType.EAGER, orphanRemoval=true)
    private Set<EmploymentHistoryEvent> employmentHistoryEvent = new HashSet<EmploymentHistoryEvent>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Set<EmploymentHistoryEvent> getEmploymentHistoryEvent() {
		return employmentHistoryEvent;
	}

	public void setEmploymentHistoryEvent(Set<EmploymentHistoryEvent> employmentHistoryEvent) {
		this.employmentHistoryEvent = employmentHistoryEvent;
	}

	
    
    
}
