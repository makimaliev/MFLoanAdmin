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
@Table(name="attachment")
public class Attachment {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
 
    @Column(name="name", nullable=false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional=true)
    @JoinColumn(name="information_id")
    private Information information;
    
    @OneToMany(mappedBy="attachment", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
    private Set<SystemFile> systemFile = new HashSet<SystemFile>();      

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

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}

	public Set<SystemFile> getSystemFile() {
		return systemFile;
	}

	public void setSystemFile(Set<SystemFile> systemFile) {
		this.systemFile = systemFile;
	}    

    
  
}
