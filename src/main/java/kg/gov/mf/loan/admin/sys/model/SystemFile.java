package kg.gov.mf.loan.admin.sys.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

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

	public String getAuCreatedBy() {
		return auCreatedBy;
	}

	public void setAuCreatedBy(String auCreatedBy) {
		this.auCreatedBy = auCreatedBy;
	}

	public Date getAuCreatedDate() {
		return auCreatedDate;
	}

	public void setAuCreatedDate(Date auCreatedDate) {
		this.auCreatedDate = auCreatedDate;
	}

	public String getAuLastModifiedBy() {
		return auLastModifiedBy;
	}

	public void setAuLastModifiedBy(String auLastModifiedBy) {
		this.auLastModifiedBy = auLastModifiedBy;
	}

	public Date getAuLastModifiedDate() {
		return auLastModifiedDate;
	}

	public void setAuLastModifiedDate(Date auLastModifiedDate) {
		this.auLastModifiedDate = auLastModifiedDate;
	}
}
