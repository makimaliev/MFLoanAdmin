package kg.gov.mf.loan.admin.org.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bank_data")

public class BankData {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
 
    @ManyToOne(targetEntity=Organization.class, fetch = FetchType.LAZY)
    @JoinColumn(name="organization_id")
    Organization organization;      
    
    @Column(name="name", nullable=false)
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="bik")
    private String bik;
    
    @Column(name="account_number")
    private String account_number;

	@Column(name="recipient")
	private String recipient;

	@Column(name="recipient_bank")
	private String recipient_bank;


	@Column(name="is_primary")
    private Boolean isPrimary;



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

	public String getBik() {
		return bik;
	}

	public void setBik(String bik) {
		this.bik = bik;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public Boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}


	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getRecipient_bank() {
		return recipient_bank;
	}

	public void setRecipient_bank(String recipient_bank) {
		this.recipient_bank = recipient_bank;
	}

	public Boolean getPrimary() {
		return isPrimary;
	}

	public void setPrimary(Boolean primary) {
		isPrimary = primary;
	}
}
