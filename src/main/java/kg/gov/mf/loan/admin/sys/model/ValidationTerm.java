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
@Table(name="validation_term")

public class ValidationTerm {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
 
    @Column(name="name", nullable=false)
    private String name;

    @Column(name="description")
    private String description;
    
    @Column(name="max_length")
    private long max_length;

    @Column(name="min_length")
    private long min_length;
    
    
    @ManyToOne(fetch = FetchType.EAGER , optional=true)
    @JoinColumn(name="object_field_id")
    private ObjectField objectField;
   
	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "ValidationTerm [id=" + id + ", name=" + name + ", description=" + description + ", max_length="
				+ max_length + ", min_length=" + min_length + ", objectField=" + objectField + "]";
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

	public long getMax_length() {
		return max_length;
	}

	public void setMax_length(long max_length) {
		this.max_length = max_length;
	}

	public long getMin_length() {
		return min_length;
	}

	public void setMin_length(long min_length) {
		this.min_length = min_length;
	}

	public ObjectField getObjectField() {
		return objectField;
	}

	public void setObjectField(ObjectField objectField) {
		this.objectField = objectField;
	}



	
   
    
}
