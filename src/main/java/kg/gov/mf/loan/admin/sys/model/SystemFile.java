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

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import kg.gov.mf.loan.admin.org.model.BankData;

@Entity
@Table(name="system_file")
public class SystemFile {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
 
    @Column(name="name", nullable=false)
    private String name;

    @Column(name="path", nullable=false)
    private String path;
    
    @ManyToOne(fetch = FetchType.LAZY , optional=true)
    @JoinColumn(name="attachment_id")
    private Attachment attachment;


	@CreatedBy
	@Column(name = "au_created_by", updatable = false)
	private String auCreatedBy;

	@CreatedDate
	@Column(name = "au_created_date", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date auCreatedDate;

	@LastModifiedBy
	@Column(name = "au_last_modified_by")
	private String auLastModifiedBy;

	@LastModifiedDate
	@Column(name = "au_last_modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date auLastModifiedDate;


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
	
	

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
    
    
    
  
}
