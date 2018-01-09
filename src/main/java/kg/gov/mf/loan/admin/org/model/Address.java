package kg.gov.mf.loan.admin.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")

public class Address {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
 
    @Column(name="line", nullable=false)
    private String line;
    
    @ManyToOne(targetEntity=Region.class, fetch = FetchType.EAGER)
    @JoinColumn(name="region_id")
    Region region;  
    
    @ManyToOne(targetEntity=District.class, fetch = FetchType.EAGER)
    @JoinColumn(name="district_id")
    District district;  
    
    
    @ManyToOne(targetEntity=Aokmotu.class, fetch = FetchType.EAGER)
    @JoinColumn(name="aokmotu_id")
    Aokmotu aokmotu;  
    
    @ManyToOne(targetEntity=Village.class, fetch = FetchType.EAGER)
    @JoinColumn(name="village_id")
    Village village;  
    
    
    @OneToOne
    @JoinColumn(name="address_details_id")
    AddressDetails AddressDetails;     
    
    
    
    

	public AddressDetails getAddressDetails() {
		return AddressDetails;
	}

	public void setAddressDetails(AddressDetails addressDetails) {
		AddressDetails = addressDetails;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Aokmotu getAokmotu() {
		return aokmotu;
	}

	public void setAokmotu(Aokmotu aokmotu) {
		this.aokmotu = aokmotu;
	}

	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}


    
    
}
