package kg.gov.mf.loan.admin.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="address_details")

public class AddressDetails {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
 
    @Column(name="name", nullable=false)
    private String name;
    
    @Column(name="line1", nullable=false)
    private String line1;
    
    @Column(name="line2", nullable=false)
    private String line2;
    
    @Column(name="soate_code", nullable=false)
    private String soate_code;



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

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getSoate_code() {
		return soate_code;
	}

	public void setSoate_code(String soate_code) {
		this.soate_code = soate_code;
	}
    
    

    
    
}
