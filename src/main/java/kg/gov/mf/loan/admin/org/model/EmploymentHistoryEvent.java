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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="employment_history_event")

public class EmploymentHistoryEvent {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
 
    @Column(name="name", nullable=false)
    private String name;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(targetEntity=EmploymentHistory.class, fetch = FetchType.EAGER)
    @JoinColumn(name="employmentHistory_id")
    EmploymentHistory employmentHistory;
    
    
    
    @ManyToOne(targetEntity=EmploymentHistoryEventType.class, fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name="employment_history_event_type_id")
    EmploymentHistoryEventType employmentHistoryEventType; 
    
    
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

	public EmploymentHistory getEmploymentHistory() {
		return employmentHistory;
	}

	public void setEmploymentHistory(EmploymentHistory employmentHistory) {
		this.employmentHistory = employmentHistory;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public EmploymentHistoryEventType getEmploymentHistoryEventType() {
		return employmentHistoryEventType;
	}

	public void setEmploymentHistoryEventType(EmploymentHistoryEventType employmentHistoryEventType) {
		this.employmentHistoryEventType = employmentHistoryEventType;
	}
	
	
	
}
