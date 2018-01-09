package kg.gov.mf.loan.admin.sys.model;

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

import kg.gov.mf.loan.admin.org.model.BankData;

@Entity
@Table(name="object_type")
public class ObjectType {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
 
    @Column(name="name")
    private String name;
    
    @Column(name="code")
    private String code;
    
    
    @OneToMany(mappedBy="objectType", fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval=true)
    private Set<ObjectField> objectField = new HashSet<ObjectField>(); 

    
    @OneToMany(mappedBy="objectType", fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval=true)
    private Set<ObjectEvent> objectEvent = new HashSet<ObjectEvent>(); 

    @OneToMany(mappedBy="objectType", fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval=true)
    private Set<FixTerm> fixTerm = new HashSet<FixTerm>();     
    
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Set<ObjectField> getObjectField() {
		return objectField;
	}

	public void setObjectField(Set<ObjectField> objectField) {
		this.objectField = objectField;
	}

	public Set<ObjectEvent> getObjectEvent() {
		return objectEvent;
	}

	public void setObjectEvent(Set<ObjectEvent> objectEvent) {
		this.objectEvent = objectEvent;
	}

	public Set<FixTerm> getFixTerm() {
		return fixTerm;
	}

	public void setFixTerm(Set<FixTerm> fixTerm) {
		this.fixTerm = fixTerm;
	}

	
	
	
}
