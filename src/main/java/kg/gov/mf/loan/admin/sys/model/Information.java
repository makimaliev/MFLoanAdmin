package kg.gov.mf.loan.admin.sys.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
@Table(name="information")
public class Information {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
 
    @Column(name="name", nullable=false)
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="number")
    private String number;
    
    @Column(name="is_title")
    private Boolean isTitle;    

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Temporal(TemporalType.DATE)
    private Date date;
    

    @OneToMany(mappedBy="information", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
    private Set<Attachment> attachment = new HashSet<Attachment>();  
    
    
    @Column(name="system_object_type_id", nullable=false)
    private long systemObjectTypeId;   

    @Column(name="system_object_id", nullable=false)
    private long systemObjectId;    
    
    
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="parent_information_id")
    public Information parentInformation;

    @OneToMany(mappedBy="parentInformation", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
    public List<Information> childInformation = new ArrayList<Information>();
    
    

    
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Boolean getIsTitle() {
		return isTitle;
	}

	public void setIsTitle(Boolean isTitle) {
		this.isTitle = isTitle;
	}

	public Set<Attachment> getAttachment() {
		return attachment;
	}

	public void setAttachment(Set<Attachment> attachment) {
		this.attachment = attachment;
	}



	public long getSystemObjectTypeId() {
		return systemObjectTypeId;
	}

	public void setSystemObjectTypeId(long systemObjectTypeId) {
		this.systemObjectTypeId = systemObjectTypeId;
	}

	public long getSystemObjectId() {
		return systemObjectId;
	}

	public void setSystemObjectId(long systemObjectId) {
		this.systemObjectId = systemObjectId;
	}

	public Information getParentInformation() {
		return parentInformation;
	}

	public void setParentInformation(Information parentInformation) {
		this.parentInformation = parentInformation;
	}

	public List<Information> getChildInformation() {
		return childInformation;
	}

	public void setChildInformation(List<Information> childInformation) {
		this.childInformation = childInformation;
	}    

    

    

}
