package kg.gov.mf.loan.admin.sys.model;

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
@Table(name="object_field")

public class ObjectField {
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
 
    @Column(name="name", nullable=false)
    private String name;

    @Column(name="description")
    private String description;
    
    @Column(name="method_name")
    private String methodName;
    
    @ManyToOne(fetch = FetchType.EAGER , optional=true)
    @JoinColumn(name="object_type_id")
    private ObjectType objectType;
    
    @OneToMany(mappedBy="objectField", fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval=true)
    private Set<ValidationTerm> validationTerm = new HashSet<ValidationTerm>(); 
   
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

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public ObjectType getObjectType() {
		return objectType;
	}

	public void setObjectType(ObjectType objectType) {
		this.objectType = objectType;
	}

	public Set<ValidationTerm> getValidationTerm() {
		return validationTerm;
	}

	public void setValidationTerm(Set<ValidationTerm> validationTerm) {
		this.validationTerm = validationTerm;
	}

	
   
    
}
