package shargin.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table (name = "frequency_by_product")
public class PriceFrequencyByProduct {
	
	@Id
	private Long id;
	
	private String name;
	
	private Long frequency;
	
	public PriceFrequencyByProduct() {}

	public PriceFrequencyByProduct(Long id, String name, Long frequency) {
		this.id=id;
		this.name = name;
		this.frequency = frequency;
	}

	public String getName() {
		return name;
	}

	public Long getFrequency() {
		return frequency;
	}

	@Override
	public int hashCode() {
		return Objects.hash(frequency, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PriceFrequencyByProduct other = (PriceFrequencyByProduct) obj;
		return Objects.equals(frequency, other.frequency) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "PriceFrequencyByProduct [id=" + id + ", name=" + name + ", frequency=" + frequency + "]";
	}


}
