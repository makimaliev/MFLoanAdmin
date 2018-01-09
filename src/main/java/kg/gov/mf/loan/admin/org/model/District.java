package kg.gov.mf.loan.admin.org.model;

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

@Entity
@Table(name="district")

public class District {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
 
    @Column(name="name", nullable=false)
    private String name;
    
    @Column(name="code", nullable=false)
    private String code;
    
    @ManyToOne(targetEntity=Region.class, fetch = FetchType.EAGER)
    @JoinColumn(name="region_id")
    Region region;    
    
    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
    private Set<Aokmotu> aokmotu = new HashSet<Aokmotu>();

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

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Set<Aokmotu> getAokmotu() {
		return aokmotu;
	}

	public void setAokmotu(Set<Aokmotu> aokmotu) {
		this.aokmotu = aokmotu;
	}


	
	
    
    
}
