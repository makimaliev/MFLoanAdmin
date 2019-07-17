package kg.gov.mf.loan.admin.org.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class GenericModelAdmin implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long version = 1;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

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
