package kg.gov.mf.loan.admin.sys.model;

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
@Table(name="message_resource")

public class MessageResource {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
 
    @Column(name="messageKey", nullable=false)
    private String messageKey;

    @Column(name="eng")
    private String eng;
    
    @Column(name="rus")
    private String rus;
    
    @Column(name="kgz")
    private String kgz;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	public String getRus() {
		return rus;
	}

	public void setRus(String rus) {
		this.rus = rus;
	}

	public String getKgz() {
		return kgz;
	}

	public void setKgz(String kgz) {
		this.kgz = kgz;
	}
   
    
    
}
