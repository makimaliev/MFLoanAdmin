package kg.gov.mf.loan.admin.sys.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

	@Column(nullable = true)
	@ElementCollection(targetClass=Long.class)
    private Set<Long> documentIds=new HashSet<Long>();

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

	public Set<Long> getDocumentIds() {
		return documentIds;
	}

	public void setDocumentIds(Set<Long> documentIds) {
		this.documentIds = documentIds;
	}
}
