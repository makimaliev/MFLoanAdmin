package kg.gov.mf.loan.admin.org.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="person")
public class Person extends BaseEntity {

	private String address_line2;

	public String getAddress_line2() {
		return address_line2;
	}

	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 83 * hash + Objects.hashCode(this.getId());
		return hash;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) return true;
		if ( !(other instanceof Person) ) return false;

		final Person person = (Person) other;

		if(person.getId() != getId()) return false;

		return true;
	}
}
